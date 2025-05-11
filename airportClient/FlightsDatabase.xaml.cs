using airportClient;
using Flights;
using System;
using System.Collections.Generic;
using System.Diagnostics;
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

namespace AirportClient
{
    public partial class FlightsDatabase : UserControl
    {

        private readonly MainWindow _mainWindow;

        public FlightsDatabase(MainWindow mainWindow)
        {
            InitializeComponent();
            LoadFlights();
            _mainWindow = mainWindow;
        }

        private async void LoadFlights()
        {
            try
            {
                var client = SoapClientFactory.CreateFlightsClientWithHeaders(UserInfo.Login, UserInfo.Password);

                var request = new Flights.AllFlightsRequest();
                var flights = await client.AllFlightsAsync(request);
                var flightsList = flights.AllFlightsResponse1.OfType<Flights.FlightDetails>().ToList();
                foreach (var flight in flightsList)
                {
                    Debug.WriteLine($"Lot: {flight.flightNumber} | {flight.date}");
                }

                FlightsDataGrid.ItemsSource = flights.AllFlightsResponse1;
           }
            catch (Exception ex)
            {
                MessageBox.Show("Błąd podczas pobierania lotów: " + ex.Message, "Błąd", MessageBoxButton.OK, MessageBoxImage.Error);            }
        }

        private void BackToMenu_Click(object sender, RoutedEventArgs e)
        {
            _mainWindow.NavigateToMainMenu();
        }

        private async void BookButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (sender is Button button && button.Tag is FlightDetails flight)
                {
                    // Tutaj masz dostęp do wszystkich danych z klikniętego wiersza:
                    string flightNumber = flight.flightNumber;
                    string from = flight.from;
                    string to = flight.to;
                    DateTime date = flight.date;
                    int price = flight.price;


                    var client = SoapClientFactory.CreateBookingClientWithHeaders(UserInfo.Login, UserInfo.Password);
                    var request = new Booking.BookingRequest();
                    request.flightNumber = flightNumber;
                    request.from = from;
                    request.to = to;
                    request.passengerName = UserInfo.Name;
                    request.passengerSurname = UserInfo.Surname;
                    request.departureDate = date;
                    request.seatClass = (Booking.SeatClass)flight.seatClass;
                    var response = await client.BookingAsync(request);
                    if (response.BookingResponse.status == Booking.BookingStatus.CONFIRMED)
                    {
                        MessageBox.Show("Confimed");
                    } else
                    {
                        MessageBox.Show("Failed");
                    }
                }
            } catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
