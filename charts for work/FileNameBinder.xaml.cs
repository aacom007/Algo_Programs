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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace SDPFReportGenerator
{
    /// <summary>
    /// Interaction logic for FileNameBinder.xaml
    /// </summary>
    public partial class FileNameBinder : UserControl
    {
        public FileNameBinder()
        {
            InitializeComponent();
        }

        public List<String> File { get ; set;  }

        public string SelectedfileName;
       
        public List<string > FileName(String url)
        {
            File = new List<string>();
          
            DirectoryInfo d;
            d = new DirectoryInfo(@"b:\users\akshay anand\documents\visual studio 2013\Projects\SDPFReportGenerator\SDPFReportGenerator\File\");//Assuming Test is your Folder
            FileInfo[] Files = d.GetFiles("*.txt"); //Getting Text files
            foreach(FileInfo file in Files )
                {
                  String s2 = @"b:\users\akshay anand\documents\visual studio 2013\Projects\SDPFReportGenerator\SDPFReportGenerator\File\"+file.Name;
                  File.Add(s2);
                }
            return File;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
          SelectedfileName =    listbox.SelectedItem.ToString();
        }
    } 
}
