   M S B A M L   `   `   `  ����  airportClient     AirportClient.FlightSearch   5      W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      $	��600��5      $	��800��6   .��5      ]� .+�5   
   �� $	��Top=�6     �� Orientation$  
Horizontal=�6*   $
��Left=�6C   $��10q�6^   .+�5      �� -   5        $��Powrót do menu��5      $
��10,5q�6G   5	      �� 5   
   $	��Top=�6   $  
Horizontal=�6*   $��10q�6C   $
��Left=�6O   $	��Top=�6j   .+�5      �� $��From:��6   $��0,0,5,0q�6%   �� 5      -   5         ��Name$ FromTextBox��5      $	��100��6+   $��0,0,10,0q�67   �� 5      $	��To:��6   $��0,0,5,0q�6#   �� 5      -   5        $ 	ToTextBox��5      $	��100��6)   $��0,0,10,0q�65   �� 5      $��Date:��6   $��0,0,5,0q�6%   (  "System.Windows.Controls.DatePicker  5      -   5          Name$ 
DatePicker��5      $	��130��6-   $��0,0,10,0q�69   �� 5      $��Seat Class:��6   $��0,0,5,0q�6+   �� 5      -   5         ��Name$ SeatClassComboBox��5      $	��100��62   $��0,0,10,0q�6>   .@�5      �� $��Economy��6   �� 5      $��Business��6   �� 5      $��First��6   5      �� 5      -   5        $��Szukaj��5      $
��10,5q�6B   5      &   System.Windows.Controls.DataGrid  5!   
   -   5          Name$ FlightsDataGrid��5!         AutoGenerateColumns$ False��5"         
IsReadOnly$
 True��5#         CanUserAddRows$ False��5$      $��10q�5%      ��5&      �� *	Flights+   Columns 5'      0  *System.Windows.Controls.DataGridTextColumn  5(      ,  &System.Windows.Controls.DataGridColumn	   Header$	 Flight Number��6%   1  +System.Windows.Controls.DataGridBoundColumn
   Binding
 6<   �� *flightNumber+  5)      $
	 From��6%   
 63   �� *from+  5*      $	 To��6%   
 61   �� *to+  5+      $
	 Date��6%   
 63   �� *date+  5,      $	 Price��6%   
 64   �� *price+4  .System.Windows.Controls.DataGridTemplateColumn  5-      $	 Akcja��6)      CellTemplate 5.      �� 5/      .R�50      �� -   5        $
��Book��50   %   
 � Tag 6M   �� 51      53      55      56      57      