public class Importer {
    public Importer(User requester, String pName) {
        this.requester = requester;
        this.organisation = requester.organisation;
        this.payroll = pName;
    }

    public void setPayroll(String pName) {
        this.payroll = pName;
    }

    public void sync() {
        ArrayList<EHEmployee> success = new ArrayList();

        if(this.payroll == 'Keypay') {
            kpEmployees = pullKPEmployees();
            for (i = 0; i < kpEmployees.length; i++) {
                kpEmployee = kpEmployees[i];
                employee = new EHEmployee(kpEmployee.name, kpEmployee.email, kpEmployee.id, this.organisation.id);
                persist(employee);
                success.add(employee);
            }
        } else if(this.payroll = 'Xero') {
            xeroEmployees = pullXeroEmployees();
            for (i = 0; i < xeroEmployees.length; i++) {
                xeroEmployee = xeroEmployees[i]
                employee = new EHEmployee(xeroEmployee.email, xeroEmployee.email, xeroEmployee.id, this.organisation.id);
                persist(employee);
                success.add(employee);
            }
        } else {
            System.out.println("Incorrect payroll system");
        }

        for (i = 0; i < success.size; i++) {
            sendInvitationEmail(success[i]);
        }
    }

    private boolean persist(EHEmployee employee) {
        // do save here, whatever ORM it is
    }

    private void sendInvitationEmail(employee) {
        // send email notification for the imported employee
    }

    private ArrayList<KPEmployee> pullKPEmployees() {
        // Implement
    }

    private ArrayList<XeroEmployee> pullXeroEmployees() {
        // Implement
    }
}

public class KPEmployee {
    int id;
    String name;
    String email;
}

public class XeroEmployee {
    String id;
    String email;
}

public class EHEmployee {
    int id;
    int organisationId;
    String externalId;
    String name;
    String email;

    public EHEmployee(name, email, externalId, organisationId) {
        // assignments here
    }
}
