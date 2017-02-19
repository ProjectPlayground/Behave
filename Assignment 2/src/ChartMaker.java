import java.util.Date;

public class ChartMaker 
{
	String filename;
	
	public ChartMaker()
	{
		
	}
	
	public void makeChart(Child child)
	{
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		for (Mode mode : child.getModeList())
		{
			for (Token token : mode.getTokens())
			{
				line_chart_dataset.addValue(token.getTimeStamp());
			}
			JFreeChart lineChartObject = ChartFactory.createLineChart(
			         mode.getName() + "Tokens over time","Time",
			         "Tokens",
			         line_chart_dataset,PlotOrientation.VERTICAL,
			         true,true,false);
			int width = 640; /* Width of the image */
		    int height = 480; /* Height of the image */ 
		    File lineChart = new File(mode.getName() + "LineChart.jpeg"); 
		    ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
		}

	}
}
