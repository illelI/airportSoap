using System.ServiceModel;
using System.ServiceModel.Channels;
using User;

namespace AirportClient
{
    public static class SoapClientFactory
    {
        public static UserPortClient CreateUserClientWithHeaders(string login, string password)
        {
            // Tworzenie klienta z domyślnymi ustawieniami
            var client = new UserPortClient(UserPortClient.GetDefaultBinding(), UserPortClient.GetDefaultEndpointAddress());

            // Ustawienie konfiguracji MTOM
            //client.Endpoint.Binding = new CustomBinding(new MtomMessageEncodingBindingElement(), new HttpTransportBindingElement());

            // Ustawienie endpointu, jeśli potrzeba
            client.Endpoint.Name = "UserPortSoap11";

            // Owijamy klienta, aby kolejne wywołania miały nagłówki
            var channel = client.InnerChannel;

            // Tworzymy scope z nagłówkami
            var contextScope = new OperationContextScope(channel);

            // Definiowanie przestrzeni nazw
            string ns = "http://ilelli.com/airport/user";

            // Dodanie nagłówków do żądania
            OperationContext.Current.OutgoingMessageHeaders.Add(
                MessageHeader.CreateHeader("login", ns, login));

            OperationContext.Current.OutgoingMessageHeaders.Add(
                MessageHeader.CreateHeader("password", ns, password));

            return client;
        }

        public static Flights.FlightsPortClient CreateFlightsClientWithHeaders(string login, string password)
        {
            var client = new Flights.FlightsPortClient(Flights.FlightsPortClient.GetDefaultBinding(), Flights.FlightsPortClient.GetDefaultEndpointAddress());

            // Ustawienie endpointu, jeśli potrzeba
            client.Endpoint.Name = "FlightsPortSoap11";

            // Owijamy klienta tak, aby kolejne wywołania miały nagłówki
            var channel = client.InnerChannel;

            // Tworzymy scope z nagłówkami
            var contextScope = new OperationContextScope(channel);

            string ns = "http://ilelli.com/airport/flights";

            OperationContext.Current.OutgoingMessageHeaders.Add(
                MessageHeader.CreateHeader("login", ns, login));

            OperationContext.Current.OutgoingMessageHeaders.Add(
                MessageHeader.CreateHeader("password", ns, password));

            return client;
        }

        public static Booking.BookingPortClient CreateBookingClientWithHeaders(string login, string password)
        {
            var client = new Booking.BookingPortClient(Booking.BookingPortClient.GetDefaultBinding(), Booking.BookingPortClient.GetDefaultEndpointAddress());

            // Ustawienie endpointu, jeśli potrzeba
            client.Endpoint.Name = "BookingPortSoap11";

            // Owijamy klienta tak, aby kolejne wywołania miały nagłówki
            var channel = client.InnerChannel;

            // Tworzymy scope z nagłówkami
            var contextScope = new OperationContextScope(channel);

            string ns = "http://ilelli.com/airport/booking";

            OperationContext.Current.OutgoingMessageHeaders.Add(
                MessageHeader.CreateHeader("login", ns, login));

            OperationContext.Current.OutgoingMessageHeaders.Add(
                MessageHeader.CreateHeader("password", ns, password));

            return client;
        }
    }
}
