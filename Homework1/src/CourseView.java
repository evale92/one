import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: CourseView
 * 
 * @author Erick Vale
 * @version 1.0 Course : ITEC 3150, Fall, 2018 
 * 
 * 
 *          This class describes a course view used to contain the courses in
 *          the course list. It also contains the main method which starts the
 *          program.
 * 
 *          Purpose: Methods and attributes needed to create a Course view of
 *          COurse class items. Print them, read them from a file,search for a
 *          particular id and add a new item.
 *
 */
public class CourseView
{

    // actual ClientList data
    private ArrayList<Course> courseList = new ArrayList<Course>();

    /**
     * Method:printCourseList()
     * 
     * This method prints the ClientList items contained in the clientListItems
     * Array list. It relies on the  method of the various Course types to
     * print the items in a user friendly format.
     * 
     * 
     */
    public void printCourseListItems()
    {
        for (int i = 0; i < courseList.size(); i++)
        {
            Course temp = courseList.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchByCRN()
     * 
     * This method looks at each item in the courseList array list and if
     * its CRN attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     * 
     * @param name
     * 
     * @return COurse
     * 
     */
    public Course searchByCRN(String name)
    {
        Course item = null;
        for (Course temp : courseList)
        {
            if (temp.getCRN().equalsIgnoreCase(name) )
            {
                item = temp;
            }

        }
        return item;
    }

    /**
     * @return the clientListItems
     */
    public ArrayList<Course> getCourseList()
    {
        return courseList;
    }

    /**
     * Method:addItem()
     * 
     * This method adds the parameter m to the courseList array list
     * 
     * @param m
     * 
     */
    public void addItem(Course m)
    {
        courseList.add(m);
    }

    /**
     * Method:removeItem()
     * 
     * This method removes the item with id from the courseList array list
     * 
     * @param m
     * 
     */
    public void removeItem(String CRN)
    {
        Course g = this.searchByCRN(CRN);
        if (g != null)
        {
            courseList.remove(g);
        }
    }

    /**
     * 
     * Method:main()
     * 
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Courses.txt and a menu for allowing user
     * to choose various tasks.
     * 
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // create ClientList by reading in from text file named media.txt
        CourseView myCourseList = new CourseView();

        // open text file
        File courseFile = new File("Courses.txt");
        // open a Scanner to read data from File
        Scanner courseReader = null;
        try
        {
        	courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e)
        {

            System.out.println("There are no classes available at this time.");

        }

        // read one course at a time
        while (courseReader != null && courseReader.hasNext())
        {

            String CRN = courseReader.nextLine();
            String courseName = courseReader.nextLine();
            String category = courseReader.nextLine();

            if (category.equalsIgnoreCase("English"))
            {
                String level = courseReader.nextLine();
                String readingOrWriting = courseReader.nextLine();
                English tp = new English(CRN, courseName, category, level, readingOrWriting);
                myCourseList.addItem(tp);

            } 
            else if (category.equalsIgnoreCase("Math"))
            {
            	String STEM = courseReader.nextLine();
                String location = courseReader.nextLine();

                Math tp = new Math(CRN, courseName, category, STEM, location);
                myCourseList.addItem(tp);

            } 
            else if (category.equalsIgnoreCase("History"))
            {
            	String areaE = courseReader.nextLine();
                String location = courseReader.nextLine();
                History tp = new History(CRN, courseName, category, areaE, location);
                myCourseList.addItem(tp);
            }
            else
            {
                System.out.println("This course is not available or does not exist: " + category);
            }

        }

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Course List");
        boolean done = false;
        while (!done)
        {
            System.out.println("Would you like to :");
            System.out.println("  1. View contents of Course List");
            System.out.println("  2. Search for a course");
            System.out.println("  3. Remove a course");
            System.out.println("  4.  Exit");
            String tp = keyboard.nextLine();
            int userInput = Integer.parseInt(tp);
            if (userInput == 1)
            {
                myCourseList.printCourseListItems();
            } else if (userInput == 2)
            {
                System.out.println("Please enter course CRN");
                String  id = keyboard.nextLine();
                Course item = myCourseList.searchByCRN(id);
                if (item != null)
                {
                    System.out.println(item);
                } else
                {
                    System.out.println("Sorry- course was not found");
                }
            } else if (userInput == 3)
            {
                System.out.println("Please enter course CRN");
                String id2 = keyboard.nextLine();
                myCourseList.removeItem(id2);
            } else
            {
                done = true;
                // write out contents of Course List back to original file
                PrintWriter out = null;
                // open file for writing
                try
                {
                    out = new PrintWriter(new File("Courses.txt"));
                } catch (FileNotFoundException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // write contents of each ClientList item to file
                for (Course g : myCourseList.getCourseList())
                {
                    // first write the attributes common to all
                    out.println(g.getCRN());
                    out.println(g.getCourseName());
                    out.println(g.getCategory()  );

                    if (g.getCategory().equalsIgnoreCase("English"))
                    {
                        // cast to appropriate subclass
                        English p = (English) g;
                        // write attributes specific to English
                        out.println(p.getLevel());
                        out.println(p.getReadingOrWriting() );

                    } else if (g.getCategory().equalsIgnoreCase("Math"))
                    {
                        // cast to appropriate subclass
                        Math c = (Math) g;
                        // write attributes specific to Math
                        out.println(c.STEM());
                        out.println(c.getLocation());
                   

                    } else if (g.getCategory().equalsIgnoreCase("History"))
                    {
                        History m = (History) g;
                        out.println(m.areaE());
                        out.println(m.getLocation());


                    } else
                    {
                        System.out.println("The course category you seek does not exit. " + g.getCategory());
                    }

                }
                out.close();

            }

        }

    }

}
