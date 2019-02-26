import java.io.Serializable;

/**
* Class: Course
 * 
 * @author Erick Vale
 * @version 1.
 *  Course : ITEC 3150,
 * 
 * 
 *          This class describes the common attributes and
 *          methods of the Courses being collected into an inventory
 * 
 *          Purpose: This class is intended to serve as a parent class only for
 *          all different types of Courses
 *
 */


public class Course implements Serializable
{
    private String CRN;
    private String courseName;
    private String category;
    

    public Course(String CRN, String courseName, String category)
    {
        super();
        this.CRN = CRN;
        this.courseName = courseName;
        this.category = category;
    }

    @Override
    /**
     * This method returns Course CRN, Course Name, and Course Category
     */
    		
    public String toString()
    {
        return "Course CRN: " + CRN + ", Course name: " + courseName + ", Category: "
                + category + ".";
    }
    public String getCRN()
    {
        return CRN;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getCategory()
    {
        return category;
    }

}
