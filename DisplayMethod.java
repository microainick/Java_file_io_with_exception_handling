public static void testDisplayAdvisorsObjects(Advisors[] advisorsArray)
  {
    /* >>>> Attention!  Add the following two lines to your import statements
    import javax.swing.*;
    import java.awt.Font;*/
    int index = 0;
    String divider = "*******************************************************";
    Font monoSpace = new Font("Courier", Font.BOLD, 20);
    JTextArea outputArea = new JTextArea("TOTAL ADVISOR COUNT: " +
            Advisors.getAdvisorCount() + "\n" + divider + "\n", 18, 30);

    while(advisorsArray[index] != null) // yes...I should use a constant
    {
      outputArea.append("Last Name: " + advisorsArray[index].getLastName()+"\n"
        + "First Name: " + advisorsArray[index].getFirstName() + "\n"
          + "Full Name: " + advisorsArray[index].getFullName() + "\n"
            + "ID: " + advisorsArray[index].getAdvisorId() + "\n"
              + "Major: " + advisorsArray[index].getMajor() + "\n"
                + "Assignees: " + advisorsArray[index].getAssignees() + "\n"
                  + divider + "\n");
      index++;
    } // end while loop
    JScrollPane scroller = new JScrollPane(outputArea);
      outputArea.setFont(monoSpace);
    JOptionPane.showMessageDialog(null, scroller,
        "Advisor Application Testing Display", JOptionPane.PLAIN_MESSAGE);
  } // end testDisplayAdvisorsObjects()