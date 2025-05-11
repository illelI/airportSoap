using airportClient;
using AirportClient;
using System;
using System.Collections.Generic;
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
    public partial class MainMenuView : UserControl
    {
        private readonly MainWindow _mainWindow;
        public MainMenuView(MainWindow mainWindow)
        {
            InitializeComponent();
            _mainWindow = mainWindow;
        }

        private void buttonFlightDatabase_Click(object sender, RoutedEventArgs e)
        {
            _mainWindow.NavigateToFlightsDatabase();
        }

        private void buttonSearchFlight_Click(object sender, RoutedEventArgs e)
        {
            _mainWindow.NavigateToFlightSearch();
        }

        private void buttonMyTickets_Click(object sender, RoutedEventArgs e)
        {
            // Logika dla moich biletów
            _mainWindow.NavigateToMyTickets();
        }

        private void buttonCheckTicket_Click(object sender, RoutedEventArgs e)
        {
            CheckTicketWindow checkTicketWindow = new CheckTicketWindow();
            checkTicketWindow.ShowDialog();
        }
    }
}
