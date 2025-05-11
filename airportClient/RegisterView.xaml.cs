using airportClient;
using System;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace AirportClient
{
    public partial class RegisterView : UserControl
    {
        private readonly MainWindow _mainWindow;
        public RegisterView(MainWindow mainWindow)
        {
            InitializeComponent();
            _mainWindow = mainWindow;
        }

        private async void Register_Click(object sender, RoutedEventArgs e)
        {
            string login = LoginBox.Text;
            string password = PasswordBox.Password;
            string firstName = NameBox.Text;
            string lastName = SurnameBox.Text;

            var client = new User.UserPortClient();
           

            // Walidacja danych użytkownika
            if (string.IsNullOrEmpty(login) || string.IsNullOrEmpty(password) || string.IsNullOrEmpty(firstName) || string.IsNullOrEmpty(lastName))
            {
                MessageBox.Show("Wszystkie pola muszą być wypełnione!", "Błąd", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            var request = new User.RegisterRequest
            {
                username = login,
                password = password,
                name = firstName,
                surname = lastName
            };

            

            var response = await client.RegisterAsync(request);

            if (response != null && response.RegisterResponse.id != null)
            {
                UserInfo.Login = login;
                UserInfo.Password = password;
                UserInfo.Name = firstName;
                UserInfo.Surname = lastName;
                UserInfo.Id = response.RegisterResponse.id;
                _mainWindow.NavigateToMainMenu();
            }

            MessageBox.Show("Rejestracja zakończona sukcesem!", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
            
        }

        private void BackToLogin_Click(object sender, RoutedEventArgs e)
        {
            _mainWindow.NavigateToLogin();
        }
    }
}
