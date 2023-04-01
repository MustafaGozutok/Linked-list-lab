public class Employee implements Comparable
{
    private String ID;
    private int salary;
    public Employee(String ID,int S)
    {
        this.ID=ID;
        salary=S;
    }

    public String toString()
    {
        String str = "";
        str += "ID:"+ID+" Salary:"+salary;
        return str;
    }



    public int compareTo(Employee e)
    {
        if(this.getSalary()>e.getSalary())
            return 1;
        else if(this.getSalary()==e.getSalary())
            return 0;
        else
            return -1;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
