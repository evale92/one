/**
 * Class: History
 * 
 * @author Erick Vale
 * @version 1.0 Course : ITEC 3150,
 * 
 * 
 *          This class describes a subclass of Course called History
 * 
 *          Purpose: Contains the attributes specific to a type of Course called
 *          History
 *
 */
public class History extends Course
{
    private String areaE;
    private String location;

    public History(String CRN, String courseName, String category,
            String areaE, String location )
    {
        super(CRN, courseName, category);
        this.areaE = areaE;
        this.location = location;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Area E Eligible:" + areaE + ",  Recorded, in-person, or online: " + location;
                
    }

    public String areaE()
    {
        return areaE;
    }


    public String getLocation()
    {
        return location;
    }

}
