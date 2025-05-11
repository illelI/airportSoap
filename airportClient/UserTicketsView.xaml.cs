using airportClient;
using AirportClient;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using User;

namespace AirportClient
{
    /// <summary>
    /// Logika interakcji dla klasy UserTicketsView.xaml
    /// </summary>
    public partial class UserTicketsView : UserControl
    {
        private readonly MainWindow _mainWindow;
        public UserTicketsView(MainWindow mainWindow)
        {
            InitializeComponent();
            _mainWindow = mainWindow;
            LoadTickets();
        }

        private async void LoadTickets()
        {
            try
            {
                var client = SoapClientFactory.CreateUserClientWithHeaders(UserInfo.Login, UserInfo.Password);

                var request = new TicketsRequest
                {
                    userId = UserInfo.Id
                };

                var response = await client.TicketsAsync(request);
                var tickets = response.TicketsResponse1?.ToList() ?? new List<TicketDetails>();

                foreach (var ticket in tickets)
                {
                    Debug.WriteLine($"Ticket: {ticket.flightNumber} | {ticket.departureDate}");
                }

                TicketsDataGrid.ItemsSource = tickets;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Błąd podczas pobierania biletów: " + ex.Message, "Błąd", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void BackToMenu_Click(object sender, RoutedEventArgs e)
        {
            _mainWindow.NavigateToMainMenu();
        }

        private async void DownloadPdf_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (sender is Button button && button.Tag is TicketDetails ticket)
                {
                    var client = SoapClientFactory.CreateUserClientWithHeaders(UserInfo.Login, UserInfo.Password);

                    var request = new TicketPdfRequest
                    {
                        ticket = ticket
                    };

                    Debug.Print(request.ticket.id);

                    var response = await client.TicketPdfAsync(request);
                    var pdfBytes = response.TicketPdfResponse;

                    if (pdfBytes != null && pdfBytes.ticketPdf.Length > 0)
                    {
                        string fileName = $"ticket_{ticket.flightNumber}_{ticket.departureDate:yyyyMMdd}.pdf";
                        File.WriteAllBytes(fileName, pdfBytes.ticketPdf);
                        MessageBox.Show($"PDF zapisany jako {fileName}");
                        Process.Start(new ProcessStartInfo(fileName) { UseShellExecute = true });
                    }
                    else
                    {
                        MessageBox.Show("Nie udało się pobrać PDF-a.");
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Błąd pobierania PDF: " + ex.Message);
            }
        }
    }

}
