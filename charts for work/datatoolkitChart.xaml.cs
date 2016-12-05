using System;
using System.Collections.Generic;
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


using System.Windows.Controls.DataVisualization;
using System.Windows.Controls.Primitives;
using System.Windows.Controls.DataVisualization.Charting;

namespace SDPFReportGenerator
{
    /// <summary>
    /// Interaction logic for datatoolkitChart.xaml
    /// </summary>
    public partial class datatoolkitChart : Window
    {
        public datatoolkitChart()
        {
            Process p = new Process();
            p.readLine();
            InitializeComponent();
            ((LineSeries)mcChart.Series[0]).ItemsSource =
       new KeyValuePair<double, double>[]{
            new KeyValuePair<double, double>(p.planNo[0], p.cpuUsage [0]),
             new KeyValuePair<double, double>(p.planNo[1], p.cpuUsage [1]),
              new KeyValuePair<double, double>(p.planNo[2], p.cpuUsage [2]),
               new KeyValuePair<double, double>(p.planNo[3], p.cpuUsage [3]),
                new KeyValuePair<double, double>(p.planNo[4], p.cpuUsage [4]),
                 new KeyValuePair<double, double>(p.planNo[5], p.cpuUsage [5])};

            ((LineSeries)mcChart.Series[1]).ItemsSource =
      new KeyValuePair<double, double>[]{
            new KeyValuePair<double, double>(p.planNo[0], p.ramUsage [0]/4000),
             new KeyValuePair<double, double>(p.planNo[1], p.ramUsage [1]/4000),
              new KeyValuePair<double, double>(p.planNo[2], p.ramUsage [2]/4000),
               new KeyValuePair<double, double>(p.planNo[3], p.ramUsage [3]/4000),
                new KeyValuePair<double, double>(p.planNo[4], p.ramUsage [4]/4000),
                 new KeyValuePair<double, double>(p.planNo[5], p.ramUsage [5]/4000)};
        }

       

    }
}
