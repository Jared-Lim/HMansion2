package demon;

import java.util.List;

public class Skills {
	private List<SingleSkill> ListOfSkills;
	
	public void setSkills(List<SingleSkill> skills){ListOfSkills = skills;}	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(SingleSkill temp : ListOfSkills){
			sb.append(temp.getName()).append(" [").append(temp.getLevel()).append("]");
			if(i++ != ListOfSkills.size()){
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}