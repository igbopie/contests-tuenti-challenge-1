package net.tuenti.contest.igbopie.taskduration.model.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import net.tuenti.contest.igbopie.taskduration.model.dao.TaskDao;
import net.tuenti.contest.igbopie.taskduration.model.entity.Task;

public class TaskDaoBigFilesImpl implements TaskDao {

	private int nTasks;
	private int firstDataLine;
	private int endDataLine;
	private int lineNumber=0;
	private BufferedReader input;
	private HashMap<String,String[]>dependencies;
	private String file;
	
	public TaskDaoBigFilesImpl(){

	}

	public void readFile(String file) throws IOException{
		this.file=file;
		input =  new BufferedReader(new FileReader(file));
		boolean numberTaskReaded=false;
		boolean taskDurationReaded=false;
		boolean dependenciesReaded=false;
		boolean firstDataLineReaded=false;
		String line="";
		nTasks=0;
		lineNumber=0;
		while((line=input.readLine())!=null){
			if(!line.trim().startsWith("#")){
				boolean blankLine=line.trim().equalsIgnoreCase("");
				if(blankLine&&!numberTaskReaded){
					numberTaskReaded=true;
				}else if(blankLine&&!taskDurationReaded){
					taskDurationReaded=true;
					endDataLine=lineNumber;
				}else if(blankLine&&!dependenciesReaded){
					dependenciesReaded=true;
				}else{

					if(!numberTaskReaded){
						nTasks=Integer.parseInt(line);
						dependencies=new HashMap<String, String[]>(nTasks);
					}else if(numberTaskReaded&&!taskDurationReaded&&!firstDataLineReaded){
						firstDataLine=lineNumber;
						input.mark(5);
						firstDataLineReaded=true;
					}else if(numberTaskReaded&&taskDurationReaded&&!dependenciesReaded){
						String[]tokens=line.split(",");
						dependencies.put(tokens[0], tokens);

					}
				}
			}
			lineNumber++;
		}
	}

	private String readLine(String id){
		//Could not save the entire collection because of its size
		try{
			String token=id+",";
			String line="";
			while((line=input.readLine())!=null&&!line.startsWith(token)&&lineNumber<endDataLine){
				lineNumber++;
			}
			if(line!=null&&line.startsWith(token)){
				return line;
			}

			lineNumber=0;
			input.close();
			input= new BufferedReader(new FileReader(file));
			line="";
			while((line=input.readLine())!=null&&!line.startsWith(token)&&lineNumber<endDataLine){
				lineNumber++;
			}

			return line;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

	synchronized public int getDuration(String id){
		//We resolve dependencies this way because of the large data file 
		int duration=0;

		String line=this.readLine(id);
		if(line!=null&&!line.equalsIgnoreCase("")){
			try{
				duration+=Integer.parseInt(line.split(",")[1]);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		String[]dependencies=this.dependencies.get(id);
		int maxduration=0;
		if(dependencies!=null){
			for(String token:dependencies){
				if(!token.equalsIgnoreCase(id)){
					int dur=this.getDuration(token);
					if(dur>maxduration){
						maxduration=dur;
					}

				}
			}			
		}

		return duration+maxduration;
	}


	@Override
	public Task getTask(String id) { 
		//NOT IMPLEMENTED
		return null;
	}

	@Override
	public Task saveTask(Task task) {
		//NOT IMPLEMENTED
		return null;
	}

	@Override
	public void removeTask(Task task) {
		//NOT IMPLEMENTED
	}

}
