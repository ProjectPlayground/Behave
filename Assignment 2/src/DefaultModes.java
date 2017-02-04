public enum DefaultModes 
{
	POSITIVE, NEGATIVE;
	
	public static String[] names() {
		DefaultModes[] modes = values();
	    String[] names = new String[modes.length];

	    for (int i = 0; i < modes.length; i++) {
	        names[i] = modes[i].name();
	    }

	    return names;
	}
	
}
