package broteen.view;

import java.util.ArrayList;
import java.util.List;

public class Issue {
private String IssueId=null;
private String IssueDescription=null;
private String[] CheckedInFiles=null;
public String getIssueId() {
	return IssueId;
}
public void setIssueId(String issueId) {
	IssueId = issueId;
}
public String getIssueDescription() {
	return IssueDescription;
}
public void setIssueDescription(String issueDescription) {
	IssueDescription = issueDescription;
}
public String[] getCheckedInFiles() {
	return CheckedInFiles;
}
public void setCheckedInFiles(String[] checkedInFiles) {
	CheckedInFiles = checkedInFiles;
}
@Override
    public String toString() {
        return this.getIssueId()+this.getIssueDescription()+this.getCheckedInFiles().toString();
    }

}
