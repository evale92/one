/**
 * Class: Math
 * 
 * @author Erick Vale
 * @version 1.0 Course : ITEC 3150,
 * 
 * 
 *          This class describes a subclass of Course called Math
 * 
 *          Purpose: Contains the attributes specific to a type of Course called
 *          Math
 *
 */
public class Math extends Course
{
    private String STEM;
    private String location;

    public Math(String CRN, String courseName, String category,
            String STEM, String location )
    {
        super(CRN, courseName, category);
        this.STEM = STEM;
        this.location = location;
    }

    @Override
    public String toString()
    {
        return super.toString() + " STEM Status: " + STEM + ", Online, in-person, or hybrid: " + location;
                
    }

    public String STEM()
    {
        return STEM;
    }


    public String getLocation()
    {
        return location;
    }

}
