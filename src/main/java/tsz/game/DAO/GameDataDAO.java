package tsz.game.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import tsz.game.model.GameData;

/**
 * Handles width game datas.
 * 
 * @author szi
 *
 */
public class GameDataDAO {
	/**
	 * The container array of read datas.
	 */
	private JSONArray jsonArray;
	
	/**
	 * Relative path to the json file.
	 */
	String pathToDataFile;
	
	/**
	 * Logger.
	 */
	Logger logger = LoggerFactory.getLogger("GameDataDAO.class");
	
	/**
	 * Constructor.
	 */
	public GameDataDAO() {
		File currentDirFile = new File("");
		String pathToDataFile = currentDirFile.getAbsolutePath();
		this.pathToDataFile = pathToDataFile.substring(0, pathToDataFile.lastIndexOf("/") + 1) + "json";
		currentDirFile.delete();
	}
	
	/**
	 * @return list of all the stored game data.
	 */
	public List<GameData> getAllGameData(){
		JSONParser parser = new JSONParser();
		List<GameData> allGamedata = new ArrayList<GameData>();
		JSONArray jArray = new JSONArray();
		
		try {
			InputStream input = new FileInputStream(new File(this.pathToDataFile));
			Reader reader = new InputStreamReader(input);
			jArray = (JSONArray) parser.parse(reader);
		} catch (IOException | ParseException e) {
			logger.error(e.toString());
		}
		
		for(int i = 0; i < jArray.size(); i++) {
			JSONObject jsonObject;
			try {
				GameData gamedata = new GameData();
				jsonObject = (JSONObject) parser.parse((String)jArray.get(i));
				
				gamedata.setPlayerName((String) jsonObject.get("playerName"));
				
				Long finalScore = (Long) jsonObject.get("finalScore");
				gamedata.setFinalScore(finalScore.intValue());
				
				gamedata.setDifficulty((String) jsonObject.get("difficulty"));
				
				allGamedata.add(gamedata);			
				
			} catch (ParseException e) {
				logger.error(e.toString());
			}
		}
		
		logger.info("Data loaded.");
		
		return allGamedata;
	}
	
	/**
	 * Write the gameplay data .
	 * @param gamedata - the last gameplay data to be stored.
	 */
	@SuppressWarnings("unchecked")
	public void saveGameData(GameData gamedata) {
		ObjectMapper mapper = new ObjectMapper();
		JSONParser parser = new JSONParser();
			
		try {
				File dataFile = new File(this.pathToDataFile);

				InputStream input = new FileInputStream(dataFile);
				Reader reader = new InputStreamReader(input);
					
				jsonArray = (JSONArray) parser.parse(reader);
				String jsonInString = mapper.writeValueAsString(gamedata);
				jsonArray.add(jsonInString);
			
				PrintWriter printWriter = new PrintWriter(dataFile);
				printWriter.write(jsonArray.toJSONString());
				printWriter.close();
							
			logger.info("Game Data saved.");
			
		} catch (IOException | ParseException e) {
			logger.error(e.toString());
		}		
	}
	
	/**
	 * Create a JSON file, if it does not exist.
	 */
	public void createFileIfNotExist() {
		File dataFile = new File(this.pathToDataFile);
		
		if(!dataFile.exists()) {
			try {
				dataFile.createNewFile();
				PrintWriter printWriter = new PrintWriter(new File(this.pathToDataFile));
				printWriter.write("[]");
				printWriter.close();
				
				logger.info("JSON file created.");
			} catch (IOException e) {
				logger.error(e.toString());;
			}
		}
	}
}
