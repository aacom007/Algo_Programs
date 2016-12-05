using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Text;

namespace SDPFReportGenerator
{
   public class Process : System.ComponentModel.INotifyPropertyChanged
    {
        public static int ii = 0;
        public static int j = 0;
        public static int k = 0;
        public static int m = 0;
        public static int n = 0;
        private double _maxCPUUsage;
        private double _MaxRAMUsage;   
        public string detector;
        public string constructor;
        public int MaxValue;
        public int[] planNo = new int[10];
        public int[] combinationNo = new int[10];
        public Double[] cpuUsage = new double[10];
        public Double[] ramUsage = new double[10];


        public double MaxCPUUsage
        {
            get { return _maxCPUUsage; }
            set { _maxCPUUsage = value; this.OnPropertyChanged("MaxCPUUsage"); }
        }

        
        public double MaxRAMUsage
        {
            get { return _MaxRAMUsage; }
            set { _MaxRAMUsage = value; this.OnPropertyChanged("MaxRAMUsage"); }
        }

        public void readLine()
        {
            int niu = 0;
            while (niu < 3)
            {

                String str = @"b:\users\akshay anand\documents\visual studio 2013\Projects\SDPFReportGenerator\SDPFReportGenerator\File\results_planPerTest" + niu.ToString() + ".txt";
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
                    {
                        if (m < 10)
                            cpuUsage[m++] = Convert.ToDouble(lineValues[ii].Substring(5, lineValues[ii].Length - 5));
                    }
                    if (lineValues[ii].Contains("RAM:"))
                    {
                        if (n < 10)
                            ramUsage[n++] = Convert.ToDouble(lineValues[ii].Substring(5, lineValues[ii].Length - 5));
                    }

                    if (lineValues[ii].Contains("Detector:"))
                    {
                        detector = lineValues[ii].Substring(10, lineValues[ii].Length - 10);
                    }


                    if (lineValues[ii].Contains("Constuctor:"))
                    {

                        constructor = lineValues[ii].Substring(13, lineValues[ii].Length - 13);
                        //chkSDPF.Content = "Operator Combination:  “" + detector.ToUpper() + "” Detection  +  “" + constructor.ToUpper() + "” Reconstruction";

                    }

                    if (lineValues[ii].Contains("Plans Per Test:"))
                    {
                        string str = lineValues[ii].Substring(17, lineValues[ii].Length - 17);
                        if (j < 10)
                            planNo[j++] = Convert.ToInt32(str);

                    }

                    if (lineValues[ii].Contains("Comb Per Plan:"))
                    {
                        string str = (lineValues[ii].Substring(15, lineValues[ii].Length - 15));
                        if (k < 10)
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

        #region INotifyPropertyChanged members
        
        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
                this.PropertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
        }

        #endregion

    }
}
