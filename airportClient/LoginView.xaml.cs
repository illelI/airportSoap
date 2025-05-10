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

            var client = new SoapClient.UserClientWithHeaders();

            var request = new User.LoginRequest();
            request.username = login;
            request.password = password;


            var response = await client.LoginAsync(request);


            if (response != null && response.LoginResponse.id != null)
            {
                UserInfo.Login = login;
                UserInfo.Password = password;
                UserInfo.Id = response.LoginResponse.id;
                _mainWindow.NavigateToMainMenu();
            }
        }
    }
}
