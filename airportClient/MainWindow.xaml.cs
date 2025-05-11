using Microsoft.Win32;
using System.Windows;

namespace AirportClient
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            MainContent.Content = new LoginView(this);
        }

        public void NavigateToRegister()
        {
            MainContent.Content = new RegisterView(this);
        }

        public void NavigateToLogin()
        {
            MainContent.Content = new LoginView(this);
        }

        public void NavigateToMainMenu()
        {
            MainContent.Content = new MainMenuView(this);
        }

        public void NavigateToFlightsDatabase()
        {
            MainContent.Content = new FlightsDatabase(this);
        }

        public void NavigateToFlightSearch()
        {
            MainContent.Content = new FlightSearch(this);
        }

        public void NavigateToMyTickets()
        {
            MainContent.Content = new UserTicketsView(this);
        }

    }
}
