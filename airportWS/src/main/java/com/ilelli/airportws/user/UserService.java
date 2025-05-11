package com.ilelli.airportws.user;

import com.ilelli.airportws.shared.Ticket;
import com.ilelli.airportws.shared.TicketRepository;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public UserService(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public RegisterResponse register(RegisterRequest request) {
        Users users = requestToUser(request);
        if (userRepository.findFirstByLogin(users.getLogin()).isPresent()) {
            throw new IllegalArgumentException();
        }
        userRepository.save(users);
        RegisterResponse response = new RegisterResponse();
        response.setId(users.getId().toString());
        response.setName(users.getName());
        response.setSurname(users.getSurname());
        return response;
    }

    public boolean checkUser(String login, String password) {
        Optional<Users> user = userRepository.findFirstByLogin(login);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public boolean checkTicket(String id) {
        return ticketRepository.findById(UUID.fromString(id)).isPresent();
    }

    public LoginResponse login(String login, String password) {
        Optional<Users> user = userRepository.findFirstByLogin(login);
        if (user.isEmpty()) {
            return null;
        }
        if (!user.get().getPassword().equals(password))
            return null;
        LoginResponse response = new LoginResponse();
        response.setId(user.get().getId().toString());
        response.setName(user.get().getName());
        response.setSurname(user.get().getSurname());
        return response;
    }

    public List<TicketDetails> getUserTickets(String userId) {
        return userRepository.findFirstById(UUID.fromString(userId)).getTickets().stream().map(this::ticketToDetailsMapper).toList();
    }

    public byte[] getTicketPdf(TicketDetails ticketDetails) {
        Ticket ticket = detailsToTicketMapper(ticketDetails);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            PdfWriter writer = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);


            document.add(new Paragraph("Passenger info")
                    .setFontSize(18)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMarginBottom(20));

            Table table = new Table(UnitValue.createPercentArray(new float[]{30, 70}))
                    .useAllAvailableWidth();

            addRow(table, "Ticket number", ticket.getId().toString());
            addRow(table, "Name", ticket.getPassengerName());
            addRow(table, "Surname", ticket.getPassengerSurname());
            addRow(table, "From", ticket.getDeparture());
            addRow(table, "To", ticket.getDestination());
            addRow(table, "Flight number", ticket.getFlightNumber());
            addRow(table, "Departure date", ticket.getDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            addRow(table, "Seat class", ticket.getSeatClass().toString());

            document.add(table);
            document.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Users requestToUser(RegisterRequest request) {
        Users users = new Users();
        users.setLogin(request.getUsername());
        users.setPassword(request.getPassword());
        users.setName(request.getName());
        users.setSurname(request.getSurname());
        return users;
    }

    private void addRow(Table table, String label, String value) {
        table.addCell(new Cell().add(new Paragraph(label)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
        table.addCell(new Cell().add(new Paragraph(value)));
    }

    private TicketDetails ticketToDetailsMapper(Ticket ticket) {
        return new TicketDetails(ticket.getId().toString(), ticket.getPassengerName(), ticket.getPassengerSurname(), ticket.getDeparture(), ticket.getDestination(), ticket.getFlightNumber(), ticket.getDepartureDate(),
                ticket.getSeatClass());
    }

    private Ticket detailsToTicketMapper(TicketDetails details) {
        Ticket ticket = new Ticket();
        ticket.setId(UUID.fromString(details.getId()));
        ticket.setPassengerName(details.getPassengerName());
        ticket.setPassengerSurname(details.getPassengerSurname());
        ticket.setDestination(details.getDestination());
        ticket.setDeparture(details.getDeparture());
        ticket.setDepartureDate(details.getDepartureDate());
        ticket.setSeatClass(details.getSeatClass());
        ticket.setFlightNumber(details.getFlightNumber());
        return ticket;
    }
}
