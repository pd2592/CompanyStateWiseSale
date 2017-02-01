package TopStateWise;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CompanyState implements WritableComparable<CompanyState> {
	Text company;
    Text state;

    public CompanyState(Text company, Text state) {
        this.company = company;
        this.state = state;
    }
    public CompanyState() {
        this.company = new Text();
        this.state = new Text();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.hadoop.io.Writable#write(java.io.DataOutput)
     */
    public void write(DataOutput out) throws IOException {
        this.company.write(out);
        this.state.write(out);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.hadoop.io.Writable#readFields(java.io.DataInput)
     */
    public void readFields(DataInput in) throws IOException {

        this.company.readFields(in);
        this.state.readFields(in);
        ;

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(CompanyState pop) {
        if (pop == null)
            return 0;
        int intcnt = company.compareTo(pop.company);
        if (intcnt != 0) {
            return intcnt;
        } else {
            return state.compareTo(pop.state);

        }
    }	@Override
	public String toString() {
		return company.toString() + "\t" + state.toString();
	}
/*
	@Override
	public int compareTo(CompanyState companystate) {
		
		 * boolean cmp = product.charAt(0) > productsize.getProduct().charAt(0);
		 * 
		 * if (cmp != 0) { return cmp; }
		 * 
		 * return (inches - productsize.getInches());
		 

		 if (companystate == null)
	            return 0;
	        int intcnt = company.compareTo(companystate.getCompany());
	        if (intcnt != 0) {
	            return intcnt;
	        } else {
	            return state.compareTo(companystate.getState());

	        }
		
		
		
		
		if (companystate == null)
			return 0;

		int intcnt = company.compareTo(companystate.getCompany());
		return intcnt == 0 ? state.compareTo(companystate.getState()) : intcnt;
	}
*/
	/*
	 * int intcnt = company.compareTo(companystate.getCompany()); int intcnt1 =
	 * 0; if (intcnt != 0) { intcnt1 = state.compareTo(companystate.getState());
	 * }
	 * 
	 * return intcnt1; //return intcnt; }
	 */

	@Override
	public int hashCode() {
		 final int prime = 31;
		    int result = 1;
		    result = prime * result + ((company == null) ? 0 : company.hashCode());
		    result = prime * result + ((state == null) ? 0 : state.hashCode());
		    return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CompanyState) {
			CompanyState companystate = (CompanyState) o;
			return (company == companystate.company && state == companystate.state);
		}
		return false;
	}

}