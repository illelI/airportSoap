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

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public UserService(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public String register(RegisterRequest request) {
        Users users = requestToUser(request);
        System.out.println(request.getName() + " XD " + request.getPassword());
        if (userRepository.findUserByLogin(users.getLogin()).isPresent()) {
            throw new IllegalArgumentException();
        }
        userRepository.save(users);
        return users.getId().toString();
    }

    public boolean checkUser(String login, String password) {
        Optional<Users> user = userRepository.findUserByLogin(login);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public String login(String login, String password) {
        Optional<Users> user = userRepository.findUserByLogin(login);
        if (user.isEmpty()) {
            return null;
        }
        return user.get().getPassword().equals(password) ? user.get().getId().toString() : null;
    }

    public List<TicketDetails> getUserTickets(String userId) {
        return List.of();
    }

    public byte[] getTicketPdf(TicketDetails ticketDetails) {
        Ticket ticket = new Ticket();
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

            addRow(table, "Name", ticket.getPassengerName());
            addRow(table, "Surname", ticket.getPassengerSurname());
            addRow(table, "Flight number", ticket.getFlightNumber());
            addRow(table, "Departure date", ticket.getDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            addRow(table, "Seat class", ticket.getSeatClass().toString());

            document.add(table);
            document.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
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
}
