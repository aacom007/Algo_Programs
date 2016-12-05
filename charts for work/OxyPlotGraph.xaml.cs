using SDPFReportGenerator.UsageViewModel;
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
using System.Windows.Threading;

namespace SDPFReportGenerator
{
    /// <summary>
    /// Interaction logic for OxyPlotGraph.xaml
    /// </summary>
    public partial class OxyPlotGraph : Window
    {
        public static int i = 0;
       
        Process xp = new Process();
        public OxyPlotGraph()
        {
            InitializeComponent();

            
            usagePointCollection = new SDPFReportGenerator.UsageViewModel.PointCollection();  
            DispatcherTimer updateCollectionTimer;
            updateCollectionTimer = new DispatcherTimer();
            updateCollectionTimer.Interval = TimeSpan.FromMilliseconds(100);
            updateCollectionTimer.Tick += new EventHandler(updateCollectionTimer_Tick);
            updateCollectionTimer.Start();


        }

        private void updateCollectionTimer_Tick(object sender, EventArgs e)
        {
            xp.readLine();
            i++;
            if (i < 6)
                usagePointCollection.Add(new UsagePoint(xp.planNo[i], xp.cpuUsage[i], (xp.ramUsage[i] / 100)));
        }


        List<Point> points = new List<Point>();
        public IEnumerable<Point> Points
        {
            get { return points; }
        }
    
public  UsageViewModel.PointCollection usagePointCollection { get; set; }}
}
