   M S B A M L   `   `   `  ����  airportClient#    AirportClient.UserTicketsView   5      W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      $	��600��5      $	��800��6   .��5      ]� .+�5   
   �� $	��Top=�6     �� Orientation$  
Horizontal=�6*   $
��Left=�6C   $��10q�6^   .+�5      �� -   5        $��Powrót do menu��5      $
��10,5q�6G   5	      &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ TicketsDataGrid��5         AutoGenerateColumns$ False��5         
IsReadOnly$
 True��5         CanUserAddRows$ False��5      $��10q�5         Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Flight Number��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6<   ��  �� Path$ flightNumber�  5      $
 From��6%    63   �� $
 from�  5      $ To��6%    61   �� $ to�  5      $ 	Departure��6%    68   �� $ departureDate�  5      $ 	Passenger��6%    68   �� $ passengerName�  5      $ Class��6%    64   �� $ 	seatClass�4  .System.Windows.Controls.DataGridTemplateColumn  5      $	 PDF��6)   	   CellTemplate	 5      �� 5      .R�5      �� -   5        $��Pobierz PDF��5   %   $	��5,2q�6e   

 � Tag
 6U   �� 6e   5      5      5!      5"      5#      