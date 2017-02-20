import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartMaker implements Serializable
{
	private static final long serialVersionUID = 6300016265948197424L;
	private int interval;
	
	public ChartMaker(int interval)
	{
		this.interval = interval;
	}
	
	public void makeChart(Child child) throws IOException
	{
		for (Mode mode : child.getModeList())
		{
			DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
			long lowest = mode.getSmallestDate();
			long highest = mode.getLargestDate();
			long range = highest - lowest;
			ArrayList<Long> dateTimes = new ArrayList<Long>();
			
			for (int i = 0; i < interval; i++)
			{
				double fraction = (double)i/(double)interval;
				double temp = ((double)range * fraction);
				dateTimes.add(lowest + (long) temp);
			}
			
			for (Long time : dateTimes)
			{
				line_chart_dataset.addValue(mode.getTokensUpToDate(time), "tokens", String.valueOf(time));
			}
			JFreeChart lineChartObject = ChartFactory.createLineChart(
			         mode.getName() + " Tokens over time","Time (UNIX / EPOCH)",
			         "Tokens",
			         line_chart_dataset,PlotOrientation.VERTICAL,
			         true,true,false);
			int width = 1280; /* Width of the image */
		    int height = 960; /* Height of the image */ 
		    File lineChart = new File(child.getName() + mode.getName() + "LineChart.jpeg");
		    ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
		}
	}
	
	public void setInterval(int interval)
	{
		this.interval = interval;
	}
}
