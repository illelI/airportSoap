   M S B A M L   `   `   `  ����  airportClient#    AirportClient.FlightsDatabase   5      W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   $	��600��5   	   $	��800��6   .��5      ]� .+�5   
   �� $	��Top=�6     �� Orientation$  
Horizontal=�6*   $
��Left=�6C   $��10q�6^   .+�5      �� -   5        $��Powrót do menu��5      $
��10,5q�6G   5	      &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ FlightsDataGrid��5         AutoGenerateColumns$ False��5         
IsReadOnly$
 True��5         CanUserAddRows$ False��5      $��10q�5         Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Flight Number��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6<   �� *flightNumber+  5      $
 From��6%    63   �� *from+  5      $ To��6%    61   �� *to+  5      $
 Date��6%    63   �� *date+  5      $ Price��6%    64   �� *price+4  .System.Windows.Controls.DataGridTemplateColumn  5      $ Action��6)      CellTemplate 5      �� 5      .R�5      �� -   5        $
��Book��5   %   $	��5,2q�6M   
	 � Tag	 6[   �� 5      5      5!      5"      5#      