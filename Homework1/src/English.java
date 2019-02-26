/**
 * Class: English
 * 
 * @author Erick Vale
 * @version 1.0 Course : ITEC 3150,
 * 
 * 
 *          This class describes a subclass of Course called English
 * 
 *          Purpose: Contains the attributes specific to a type of Course called
 *          English
 *
 */
public class English extends Course
{
    private String level;
    private String readingOrWriting;

    public English(String CRN, String courseName, String category,
            String level, String readingOrWriting )
    {
        super(CRN, courseName, category);
        this.level = level;
        this.readingOrWriting = readingOrWriting;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Class Level: " + level + ", Reading or Writing Course: " + readingOrWriting;
                
    }

    public String getLevel()
    {
        return level;
    }


    public String getReadingOrWriting()
    {
        return readingOrWriting;
    }

}
