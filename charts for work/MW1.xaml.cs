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
using System.Windows.Controls.DataVisualization.Charting;
using System.Windows.Media.Imaging;

// Auto chart generation module for production test results.
// 
// Author : Akshay Anand
// Dated: 31/November/2016
// 

namespace SDPFReportGenerator
{
    /// <summary>

    /// MW is main window for new graph for each person worked on files.
    /// </summary>
    public partial class MW1 :Window, INotifyPropertyChanged
    {
        public static String str;
        public static int mm=0;
        public static bool flag = true;
        public int ii=0;
        public int j=0;
        public int k=0;
        public int m=0;
        public int n=0;
        public int saved=0;
        public string detector;
        public string constructor;
        public int MaxValue;
        internal int [] planNo=new int [10];
        internal int [] combinationNo=new int [10];
        internal Double [] cpuUsage=new double [10];
        internal Double [] ramUsage=new double [10];
        private double _maxCPUUsage;
        private double _MaxRAMUsage;
        private string chartTitle;

        public double MaxCPUUsage
        {
            get
            {
                return _maxCPUUsage;
            }
            set
            {
                _maxCPUUsage=value;
                this.OnPropertyChanged("MaxCPUUsage");
            }
        }

        public string selectname;
        public double MaxRAMUsage
        {
            get
            {
                return _MaxRAMUsage;
            }
            set
            {
                _MaxRAMUsage=value;
                this.OnPropertyChanged("MaxRAMUsage");
            }
        }


        public void readLine(string selectname)
        {
            int niu=0;

            str = @"C:\Work\Git\Cisoft\engine\spdf\Charts For Work\test\Level1_CSVFile_copy.csv";// +niu.ToString() + ".csv";
                //@"C:\Users\Akshay\SDPF_New\engine\spdf\DynamicDataDisplaySample\test\signal_spike" + niu.ToString() + ".txt";
        

            StreamReader sr=new StreamReader(str);
            
            while(!sr.EndOfStream)
            {
                if (niu > 9) {
                    break;
                }
                
                niu++;
                CheckString(sr.ReadLine());
            }
        }

        public  void CheckString(string line)
        {
            string TempLine         = line;
            string [] lineValues    = line.Split(',');
            
            if ( TempLine != null && TempLine != "" )
            {
                
                    if (!lineValues[2].Contains("WORK"))
                    {
                        
                            cpuUsage [m++] = Convert.ToDouble(lineValues [2].ToString()) ;
                    }
                    if (! lineValues [1].Contains("DAYS") )
                    {
                        
                            ramUsage [n++] = (Convert.ToDouble(lineValues [1].ToString())%5);
                    }
                    if ( !lineValues [0].Contains("NAME") )
                    {
                        detector        = lineValues [0].ToString();
                    }
                    
                     
                 
            }
        }

        public SDPFReportGenerator.UsageViewModel.PointCollection usagePointCollection;

        DispatcherTimer updateCollectionTimer;

        private int i=0;

        public MW1()
        {
            InitializeComponent();
            double [] outr=new double [1];
            double [] outm=new double [1];

            this.DataContext=this;
            usagePointCollection=new SDPFReportGenerator.UsageViewModel.PointCollection();
            updateCollectionTimer=new DispatcherTimer();
            updateCollectionTimer.Interval=TimeSpan.FromMilliseconds(100);
            updateCollectionTimer.Tick+=new EventHandler(updateCollectionTimer_Tick);
            updateCollectionTimer.Start();

            for(int ip=0 ; ip<6 ; ip++)
            {
                if(planNo [ip]==MaxValue)
                {
                    outr [0]=ip;
                    outm [0]=MaxValue;
                }
            }
            MaxCPUUsage=30;
            _MaxRAMUsage=75;
        }

        static double CompareFirst(KeyValuePair<double, double> a, KeyValuePair<double, double> b)
        {
            return a.Key.CompareTo(b.Key);
        }

        static double CompareSecond(KeyValuePair<double, double> a, KeyValuePair<double, double> b)
        {
            return a.Value.CompareTo(b.Value);
        }

      

        private void LoadLineChartData()
        {


            //Utilization Data plotting
            LineSeries ls=new LineSeries();
            ls.Title="% Memory Utilization";
            ls.IndependentValueBinding=new System.Windows.Data.Binding("Key");
            ls.DependentValueBinding=new System.Windows.Data.Binding("Value");
            KeyValuePair<Double, Double> [] list=new KeyValuePair<Double, Double> []
            {
                 new KeyValuePair<Double, Double>(   ramUsage[0],   cpuUsage[0]),
                 new KeyValuePair<Double, Double>(  ramUsage[1],    cpuUsage[1]),
                 new KeyValuePair<Double, Double>(   ramUsage[2],   cpuUsage[2]),
                 new KeyValuePair<Double, Double>( ramUsage[3],     cpuUsage[3]),
                 new KeyValuePair<Double, Double>(  ramUsage[4],    cpuUsage[4]),
                 new KeyValuePair<Double, Double>( ramUsage[5],     cpuUsage[5])};

            //binding ram value list to item. 
           // list =  sortKeyVpair(list);
            ls.ItemsSource=list;
            //adding it to chart  
            mcChart.Series.Add(ls);


            //CPU Utilization Data plotting
            LineSeries ls1=new LineSeries();
            ls1.Title="% CPU Overload Ratio";
            ls1.IndependentValueBinding=new System.Windows.Data.Binding("Key");
            ls1.DependentValueBinding=new System.Windows.Data.Binding("Value");
            ls1.ItemsSource=new KeyValuePair<Double, Double> []
            {
                 new KeyValuePair<Double, Double>( planNo[0], cpuUsage [0]),
                 new KeyValuePair<Double, Double>( planNo[1], cpuUsage[1]),
                 new KeyValuePair<Double, Double>( planNo[2], cpuUsage[2]),
                 new KeyValuePair<Double, Double>( planNo[3],cpuUsage[3]),
                 new KeyValuePair<Double, Double>( planNo[4],cpuUsage[4]),
                 new KeyValuePair<Double, Double>( planNo[5],cpuUsage[5])};

            mcChart.Series.Add(ls1);

            // Adding Threshold lines value (CPU and RAM)

            LineSeries ls3=new LineSeries();
            LineSeries ls4=new LineSeries();
            //adding title
            ls3.Title="CPU Utilization Threshold";
            ls4.Title="RAM Utilization Threshold";
            ls3.IndependentValueBinding=new System.Windows.Data.Binding("Key");
            ls3.DependentValueBinding=new System.Windows.Data.Binding("Value");
            ls4.IndependentValueBinding=new System.Windows.Data.Binding("Key");
            ls4.DependentValueBinding=new System.Windows.Data.Binding("Value");
            KeyValuePair<Double, Double> [] cpu1=new KeyValuePair<Double, Double> [6];
            KeyValuePair<Double, Double> [] ram1=new KeyValuePair<Double, Double> [6];
            //int j=1;
            for(int i=0 ; i<6 ; i++)
            {

                // RAM utilization threshold is 75%
                ram1 [i]=new KeyValuePair<double, double>(planNo [i], 75.0);
                // CPU utilization threshold is 30%
                cpu1 [i]=new KeyValuePair<double, double>(planNo [i], 30.0);
            }

            ls3.ItemsSource=cpu1;
            ls4.ItemsSource=ram1;
            mcChart.Series.Add(ls3);
            mcChart.Series.Add(ls4);
        }

        //Function to save final image at a local location.
        void saveimage()
        {
            saved++;
            RenderTargetBitmap renderBitmap=new RenderTargetBitmap(
            (int)mcChart.ActualWidth,
            (int)mcChart.ActualHeight,
             96d,
             96d,
            PixelFormats.Pbgra32);
            mcChart.UpdateLayout();
            renderBitmap.Render(mcChart);
            string temp=str;
            //Output file name and location
            str=str+"_"+chartTitle+"_out.png";

            // Create a file stream for saving image
            using(FileStream outStream=new FileStream(str, FileMode.Create))
            {
                // Use png encoder for our data
                PngBitmapEncoder encoder=new PngBitmapEncoder();
                // push the rendered bitmap to it
                encoder.Frames.Add(BitmapFrame.Create(renderBitmap));
                // save the data to the stream
                encoder.Save(outStream);
            }
            str=temp;
        }

        //Update ticker to call the dispatcher event on each tick to evaluate real time results.
        void updateCollectionTimer_Tick(object sender, EventArgs e)
        {
            if (flag)
            {

                readLine(str);
                flag = false;
            }
            i++;
            if(i<planNo.Length)
                usagePointCollection.Add(new UsagePoint(planNo [i], cpuUsage [i]/100, (ramUsage [i])));
            if(mm==0)
            {
                mm=1;
                LoadLineChartData();
                if(saved<planNo.Length)
                    saveimage();

            }
            if(saved<planNo.Length)
                saveimage();
        }



        #region INotifyPropertyChanged members
        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string propertyName)
        {
            if(PropertyChanged!=null)
                this.PropertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
        }

        #endregion

        private void Button_Click(object sender, RoutedEventArgs e)
        {
        }
    }



}