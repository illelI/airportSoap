using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;
using User;

namespace AirportClient
{
    class SoapClient
    {
        public UserClientWithHeaders UserClient { get; }

        public SoapClient() {
            UserClient = new UserClientWithHeaders();
        }


        [MessageContract]
        class LoginHeader
        {
            [MessageHeader]
            private String Login { get; }
            [MessageHeader]
            private String Password { get; }

            public LoginHeader()
            {
                Login = airportClient.UserInfo.Login;
                Password = airportClient.UserInfo.Password;
            }
        }

        public partial class UserClientWithHeaders : User.UserPortClient
        {
            public UserClientWithHeaders()
        : base(UserPortClient.GetDefaultBinding(), UserPortClient.GetDefaultEndpointAddress())
            {
                this.Endpoint.Name = EndpointConfiguration.UserPortSoap11.ToString();
                ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
            }

            static void ConfigureEndpoint(System.ServiceModel.Description.ServiceEndpoint serviceEndpoint, System.ServiceModel.Description.ClientCredentials clientCredentials)
            {

            }

            // Metoda do dodania nagłówków
            public void AddLoginHeader()
            {
                // Tworzymy nagłówek
                var loginHeader = new LoginHeader();

                // Dodajemy nagłówek do kontekstu operacji
                using (new OperationContextScope(this.InnerChannel))
                {
                    var messageHeaders = OperationContext.Current.OutgoingMessageHeaders;
                    var header = new MessageHeader<LoginHeader>(loginHeader);
                    var headerContents = header.GetUntypedHeader("LoginHeader", "http://ilelli.com/airport/user");

                    // Dodajemy nagłówek do wiadomości
                    messageHeaders.Add(headerContents);
                }
            }

        }
    }
}
