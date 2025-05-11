using AirportClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace airportClient
{
    /// <summary>
    /// Logika interakcji dla klasy CheckTicketWindow.xaml
    /// </summary>
    public partial class CheckTicketWindow : Window
    {
        public CheckTicketWindow()
        {
            InitializeComponent();
        }

        private async void CheckTicketButton_Click(object sender, RoutedEventArgs e)
        {
            try { 

            var client = SoapClientFactory.CreateUserClientWithHeaders(UserInfo.Login, UserInfo.Password);
            var request = new User.CheckTicketRequest();
            request.ticketId = TicketInput.Text;
            var response = await client.CheckTicketAsync(request);
            string message;
            if(response.CheckTicketResponse.result)
            {
                message = "Valid";
            }
            else
            {
                message = "Invalid";
            }
            MessageBox.Show(message);
        } catch (Exception ex)
            {
                MessageBox.Show("Invalid");
            }
            }
    }
}
