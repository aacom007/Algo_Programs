using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Research.DynamicDataDisplay.Common;

namespace SDPFReportGenerator.UsageViewModel
{
    public class PointCollection : RingArray  <UsagePoint>
    {
        private const int TOTAL_POINTS = 300;

        public PointCollection()
            : base(TOTAL_POINTS) // here i set how much values to show 
        {    
        }
    }

    public class UsagePoint
    {        
        public double CPU { get; set; }
        
        public double Plan { get; set; }

        public double Ram { get; set; }
        public UsagePoint(double Plan, double CPU, double ram)
        {
            this.CPU = CPU;
            this.Plan = Plan;
            this.Ram = ram;
        }
    }
}
