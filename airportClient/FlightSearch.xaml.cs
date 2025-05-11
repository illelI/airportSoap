using airportClient;
using Booking;
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
using System.Xml;

namespace AirportClient
{
    /// <summary>
    /// Logika interakcji dla klasy FlightSearch.xaml
    /// </summary>
    public partial class FlightSearch : UserControl
    {
        private readonly MainWindow _mainWindow;
        public FlightSearch(MainWindow mainWindow)
        {
            InitializeComponent();
            _mainWindow = mainWindow;
        }

        private async void SearchFlights_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                var from = FromTextBox.Text;
                var to = ToTextBox.Text;

                if (string.IsNullOrWhiteSpace(from) || string.IsNullOrWhiteSpace(to))
                {
                    MessageBox.Show("Uzupełnij pola 'From' i 'To'", "Błąd", MessageBoxButton.OK, MessageBoxImage.Warning);
                    return;
                }

                if (DatePicker.SelectedDate == null)
                {
                    MessageBox.Show("Wybierz datę wylotu", "Błąd", MessageBoxButton.OK, MessageBoxImage.Warning);
                    return;
                }

                var departureDate = DatePicker.SelectedDate.Value.Date;

                var seatClassText = (SeatClassComboBox.SelectedItem as ComboBoxItem)?.Content.ToString();
                if (string.IsNullOrEmpty(seatClassText))
                {
                    MessageBox.Show("Wybierz klasę miejsca", "Błąd", MessageBoxButton.OK, MessageBoxImage.Warning);
                    return;
                }

                Flights.SeatClass seatClass;
                switch (seatClassText)
                {
                    case "Economy":
                        seatClass = Flights.SeatClass.ECONOMY;
                        break;
                    case "Business":
                        seatClass = Flights.SeatClass.BUSINESS;
                        break;
                    case "First":
                        seatClass = Flights.SeatClass.FIRST;
                        break;
                    default:
                        throw new Exception("Nieprawidłowa klasa miejsca");
                }

                var client = SoapClientFactory.CreateFlightsClientWithHeaders(UserInfo.Login, UserInfo.Password);

                var request = new Flights.FlightsRequest
                {
                    from = from,
                    to = to,
                    Date = new DateTime(departureDate.Year, departureDate.Month, departureDate.Day, 12, 0, 0),
                    seatClass = seatClass
                };

                Debug.Print("Date (string): " + request.DateString);

                var response = await client.FlightsAsync(request);

                FlightsDataGrid.ItemsSource = response.FlightsResponse1;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Błąd podczas wyszukiwania lotów: " + ex.Message, "Błąd", MessageBoxButton.OK, MessageBoxImage.Error);
            }
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
                    }
                    else
                    {
                        MessageBox.Show("Failed");
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }


    }
}
