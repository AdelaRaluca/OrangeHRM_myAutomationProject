package modelObject;

public class AddJobTitleModel extends BaseModel {

    public AddJobTitleModel(String jsonFilePath) {
        super(jsonFilePath);
    }

    private String jobTitleInput;
    private String jobDescriptionInput;
    private String noteInput;
    private String jobSpecificationFile;

    public String getJobTitleInput() {
        return jobTitleInput;
    }

    public void setJobTitleInput(String jobTitleInput) {
        this.jobTitleInput = jobTitleInput;
    }

    public String getJobDescriptionInput() {
        return jobDescriptionInput;
    }

    public void setJobDescriptionInput(String jobDescriptionInput) {
        this.jobDescriptionInput = jobDescriptionInput;
    }

    public String getNoteInput() {
        return noteInput;
    }

    public void setNoteInput(String noteInput) {
        this.noteInput = noteInput;
    }

    public String getJobSpecificationFile() {
        return jobSpecificationFile;
    }

    public void setJobSpecificationFile(String jobSpecificationFile) {
        this.jobSpecificationFile = jobSpecificationFile;
    }
}
