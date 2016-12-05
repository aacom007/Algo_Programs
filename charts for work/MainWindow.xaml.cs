using System.Windows;
using SDPFReportGenerator.UsageViewModel;
using System.Windows.Threading;
using System;
using Microsoft.Research.DynamicDataDisplay.DataSources;
using Microsoft.Research.DynamicDataDisplay;
using System.Windows.Media;
using System.ComponentModel;
using System.IO;
using System.Collections.Generic;

namespace SDPFReportGenerator
{
    /// <summary>
    /// Logica di interazione per MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        public static int ii = 0;
        public static int j = 0;
        public static int k = 0;
        public static int m = 0;
        public static int n = 0;
        public string detector;
        public string constructor;
        public int MaxValue;
        internal  int[] planNo = new int[10];
        internal int[] combinationNo = new int[10];
        internal  Double[] cpuUsage = new double[10];
        internal  Double[] ramUsage = new double[10];
        private double _maxCPUUsage;
        private double _MaxRAMUsage;
        public double MaxCPUUsage
        {
            get { return _maxCPUUsage; }
            set { _maxCPUUsage = value; this.OnPropertyChanged("MaxCPUUsage"); }
        }
        
        public string selectname;
        public double MaxRAMUsage
        {
            get { return _MaxRAMUsage; }
            set { _MaxRAMUsage = value; this.OnPropertyChanged("MaxRAMUsage"); }
        }
        FileNameBinder p;

        public void readLine()
        {
            int niu=0;
            while(niu<3)
            {
                String str = @"b:\users\akshay anand\documents\visual studio 2013\Projects\SDPFReportGenerator\SDPFReportGenerator\File\results_planPerTest"+ niu.ToString()+".txt";

                if (!String.IsNullOrEmpty(selectname))
                    str = selectname;
               
              p  = new FileNameBinder();
              p.FileName(p.txtbox.ToString());
              p.listbox.ItemsSource = p.File;
             

                ListPanel.Children.Add(p);
                
                StreamReader sr = new StreamReader(str);
                niu++;
                  while (!sr.EndOfStream)
                 {
                      CheckString(sr.ReadLine());
                 }
            }
        }

        private void CheckString(string line)
        {
            string TempLine = line;
            string[] lineValues = line.Split(',');
            if (TempLine != null && TempLine != "")
            {
                ii = 0;
                while (ii < lineValues.Length)
                {
                    if (lineValues[ii].Contains("CPU:"))
                    { if(m<10)
                        cpuUsage[m++]  = Convert.ToDouble( lineValues[ii].Substring(5, lineValues[ii].Length - 5));
                    }
                    if (lineValues[ii].Contains("RAM:"))
                    {
                        if(n<10)
                        ramUsage[n++] = Convert.ToDouble(lineValues[ii].Substring(5, lineValues[ii].Length - 5));
                    }
                    if (lineValues[ii].Contains("Detector:"))
                    {
                        detector = lineValues[ii].Substring(10, lineValues[ii].Length - 10);
                    }
                    if (lineValues[ii].Contains("Constuctor:"))
                    {
                        constructor = lineValues[ii].Substring(13, lineValues[ii].Length - 13);
                        chkSDPF.Content = "Operator Combination:  “" + detector.ToUpper() + "” Detection  +  “" + constructor.ToUpper() + "” Reconstruction";
                    }

                    if (lineValues[ii].Contains("Plans Per Test:"))
                    {
                        string str = lineValues[ii].Substring(17, lineValues[ii].Length - 17);
                       if(j<10)
                        planNo[j++] = Convert.ToInt32(str);
                        
                    }

                    if (lineValues[ii].Contains("Comb Per Plan:"))
                    {
                        string str = (lineValues[ii].Substring(15, lineValues[ii].Length - 15));
                        if(k<10)
                        combinationNo[k++] = Convert.ToInt32(str);
                        
                    }


                    if (lineValues[ii].Contains("MaxValue:"))
                    {
                        MaxValue = Convert.ToInt32((lineValues[ii].Substring(10, lineValues[ii].Length - 10)));
                    }
                    ii++;


                }

            }

        }

        public SDPFReportGenerator.UsageViewModel.PointCollection usagePointCollection; 

        DispatcherTimer updateCollectionTimer;

        private int i = 0;

        public MainWindow()
        {
            InitializeComponent();
            double[] outr = new double[1];
            double[] outm = new double[1];
            
            this.DataContext = this;
            usagePointCollection = new SDPFReportGenerator.UsageViewModel.PointCollection();               
          
            updateCollectionTimer = new DispatcherTimer();
            updateCollectionTimer.Interval = TimeSpan.FromMilliseconds(100);
            updateCollectionTimer.Tick += new EventHandler(updateCollectionTimer_Tick);
            updateCollectionTimer.Start();

            for(int ip=0;ip<6;ip++)
            {
                if(planNo[ip]==MaxValue )
                {
                    outr[0] = ip;
                    outm[0] = MaxValue;
                }
            }

            var xCoord = new EnumerableDataSource<int>( outr  );
            xCoord.SetXMapping(t => t);
            var yCoord = new EnumerableDataSource<int>(outm );
            yCoord.SetYMapping(k => k);
            CompositeDataSource p = new CompositeDataSource(xCoord,yCoord);
           // plotter.AddLineGraph(p, Brushes.Red.Color , 2, "Threshold Value for "+detector  +"  " + constructor +" combination"  );
                      
            var ds = new EnumerableDataSource<UsagePoint>(usagePointCollection);
            ds.SetXMapping(x => dateAxis.ConvertToDouble( x.Plan ));
            ds.SetYMapping(y => (y.CPU * 100));
            var ds2 = new EnumerableDataSource<UsagePoint>(usagePointCollection);
            ds2.SetXMapping(x => dateAxis.ConvertToDouble( x.Plan ));
            ds2.SetYMapping(y => y.Ram );
           
            MaxCPUUsage = 30;
            _MaxRAMUsage  = 75;

            
            plotter.AddLineGraph  (ds,Colors.Green,2, "CPUUsage"); // to use this method you need "using Microsoft.Research.DynamicDataDisplay;"
            plotter.AddLineGraph (ds2, Colors.Blue, 2, "RAMUsage"); // to use this method you need "using Microsoft.Research.DynamicDataDisplay;"

        }

        void updateCollectionTimer_Tick(object sender, EventArgs e)
        {
            readLine();
            i++;
            if(i<6)
                usagePointCollection.Add(new UsagePoint(planNo[i], cpuUsage[i], (ramUsage[i]/100)));
        }

        #region INotifyPropertyChanged members

        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
                this.PropertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
        }

        #endregion

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if(!String.IsNullOrEmpty (p.SelectedfileName))
            selectname = p.SelectedfileName ;
           

        }
    }



}
