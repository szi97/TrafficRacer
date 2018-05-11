package tsz.game.DAO;

import java.io.File;
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

public class GameDataDAO {
	private JSONArray jsonArray;
	
	Logger logger = LoggerFactory.getLogger("GameDataDAO.class");
	
	public List<GameData> getAllGameData(){
		JSONParser parser = new JSONParser();
		List<GameData> allGamedata = new ArrayList<GameData>();
		JSONArray jArray = new JSONArray();
		
		InputStream input = GameDataDAO.class.getClassLoader().getResourceAsStream("data/json");
		Reader reader = new InputStreamReader(input);
		
		try {
			jArray = (JSONArray) parser.parse(reader);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		
		logger.info("Data loaded.");
		
		return allGamedata;
	}
	
	@SuppressWarnings("unchecked")
	public void saveGameData(GameData gamedata) {
		ObjectMapper mapper = new ObjectMapper();
		JSONParser parser = new JSONParser();
		InputStream input = GameDataDAO.class.getClassLoader().getResourceAsStream("data/json");
		Reader reader = new InputStreamReader(input);
		
		try {
			jsonArray = (JSONArray) parser.parse(reader);
			String jsonInString;
			jsonInString = mapper.writeValueAsString(gamedata);
			jsonArray.add(jsonInString);
			
			PrintWriter printWriter = new PrintWriter(new File(GameDataDAO.class.getClassLoader().getResource("data/json").getPath()));
			printWriter.write(jsonArray.toJSONString());
			printWriter.close();
			
			logger.info("Game Data saved.");
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
