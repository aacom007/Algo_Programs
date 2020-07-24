using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace SDPFReportGenerator
{
    /// <summary>
    /// Interaction logic for Start.xaml
    /// </summary>
    public partial class Start :Window
    {
        public Start()
        {  
            InitializeComponent();
            String dir ="B:\\Users\\akshay anand\\Documents\\Visual Studio 2013\\Projects\\SDPFReportGenerator\\SDPFReportGenerator\\File\\fileIn";
            String[] filepaths = Directory.GetFiles(dir);
             
            foreach (string filepath in filepaths)
            {
                cmbBox.Items.Add(filepath);
            }

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            MW1 x;
            x       = new MW1();
            MW1.str = cmbBox.SelectedValue.ToString();
        }
    }
}
