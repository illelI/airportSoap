using airportClient;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace AirportClient
{
    public partial class LoginView : UserControl
    {
        private readonly MainWindow _mainWindow;

        public LoginView(MainWindow mainWindow)
        {
            InitializeComponent();
            _mainWindow = mainWindow;
        }

        private void Register_Click(object sender, RoutedEventArgs e)
        {
            _mainWindow.NavigateToRegister();
        }

        private async void Login_Click(object sender, RoutedEventArgs e)
        {
            string login = LoginBox.Text;
            string password = PasswordBox.Password;

           


            // Walidacja danych użytkownika
            if (string.IsNullOrEmpty(login) || string.IsNullOrEmpty(password))
            {
                MessageBox.Show("Wszystkie pola muszą być wypełnione!", "Błąd", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            UserInfo.Login = login;
            UserInfo.Password = password;

            var client = SoapClientFactory.CreateUserClientWithHeaders(login, password);
            var request = new User.LoginRequest { username = login, password = password };

            var response = await client.LoginAsync(request);

            if (response != null && response.LoginResponse.id != null)
            {
                UserInfo.Id = response.LoginResponse.id;
                UserInfo.Name = response.LoginResponse.name;
                UserInfo.Surname = response.LoginResponse.surname;
                _mainWindow.NavigateToMainMenu();
            }
        }
    }
}
