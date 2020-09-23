/**********************************************************
Developer: Larry Hill and Nicholas Marien
Course and Section: CIT 38800 Section 25901
Assignment Number: Three
Due Date and Time: 11/25/19 at 11:59pm
File Name: Advisors.java
Description:
This is class is my abstract datatype Advisors.  I am going to make three
constructors.  I am going to write 1 set method and 1 get method for each
private variable.  1 get method for fullname.  1 setter method for
counter, which is the only static variable.

**********************************************************/

public class Advisors
{
  private
    String fName;
    String lName;
    String advisorId;
    String major;
    int assignees;

  public static int counter;

  public
    static final int DEFAULT_ASS_LOW = 35;
    static final int DEFAULT_ASS_HIGH = 999;
    static final int RANGE_ASS_LOW_MINUS = 19;
    static final int RANGE_ASS_LOW = 20;
    static final int RANGE_ASS_HIGH = 200;
    static final int RANGE_ASS_HIGH_PLUS = 201;
    static final int RANGE_FN_MIN = 2;
    static final int RANGE_LN_MIN = 4;
    static final int VALUE_ADV_ID = 10;
    static final int RANGE_MAJ_MIN = 3;
    static final int RANGE_MAJ_MAX = 8;
    static final String UNKNOWN = "**UNKNOWN**";

  Advisors()
  {
    setFirstName(UNKNOWN);
    setLastName(UNKNOWN);
    setAdvisorId(UNKNOWN);
    setMajor(UNKNOWN);
    setAssignees(DEFAULT_ASS_HIGH);
    counter++;
  }

  Advisors(String fn, String ln, String advId, String maj)
  {
    setFirstName(fn);
    setLastName(ln);
    setAdvisorId(advId);
    setMajor(maj);
    setAssignees(DEFAULT_ASS_LOW);
    counter++;
  }

  Advisors(String fn, String ln, String advId, String maj, int asNum)
  {
    setFirstName(fn);
    setLastName(ln);
    setAdvisorId(advId);
    setMajor(maj);
    setAssignees(asNum);
    counter++;
  }

  public static int getAdvisorCount()
  {
    return counter;
  }

  public void setFirstName(String sValFname)
  {
    if (sValFname != null && sValFname.length() > RANGE_FN_MIN)
    {
      fName = sValFname;
    }
    else
    {
      fName = UNKNOWN;
    }
  }

  public String getFirstName()
  {
    return fName;
  }

  public void setLastName(String sValLName)
  {
    if (sValLName != null && sValLName.length() > RANGE_LN_MIN)
    {
      lName = sValLName;
    }
    else
    {
      lName = UNKNOWN;
    }
  }

  public String getLastName()
  {
    return lName;
  }

  public String getFullName()
  {
    String myVarFN = getFirstName();
    String myVarLN = getLastName();
    String myFullNameVar = myVarLN + ", " + myVarFN;

    return myFullNameVar;
  }

  public void setAdvisorId(String sValAdvId)
  {
    if (sValAdvId != null && sValAdvId.length() == VALUE_ADV_ID &&
        sValAdvId.matches("[0-9]+"))
    {
      advisorId = sValAdvId;
    }
    else
    {
      advisorId = UNKNOWN;
    }
  } //end set

  public String getAdvisorId()
  {
    return advisorId;
  }

  public void setMajor(String sValMajor)
  {
    if (sValMajor != null && sValMajor.length() > RANGE_MAJ_MIN &&
        sValMajor.length() < RANGE_MAJ_MAX)
    {
      major = sValMajor;
    }
    else
    {
      major = UNKNOWN;
    }
  }

  public String getMajor()
  {
    return major;
  }

  public void setAssignees(int sValAssNum)
  {
    if (sValAssNum > RANGE_ASS_LOW_MINUS && sValAssNum < RANGE_ASS_HIGH_PLUS)
    {
      assignees = sValAssNum;
    }
    else if (sValAssNum < RANGE_ASS_LOW || sValAssNum > RANGE_ASS_HIGH)
    {
      assignees = DEFAULT_ASS_HIGH;
    }
    else
    {
      assignees = DEFAULT_ASS_LOW;
    }
  }

  public int getAssignees()
  {
     return assignees;
  }
}
