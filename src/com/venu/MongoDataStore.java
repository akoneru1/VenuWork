package com.venu;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDataStore {

	public static void main(String rags[]){
		MongoClient mongo = null;
		long startTime = System.currentTimeMillis();
		try {
			mongo = new MongoClient();
			DB db = mongo.getDB("modivapp");
			db.dropDatabase();
			/*DBCollection mongoCollection = db.getCollection("predictionData"); 
			
			for(int i = 0; i < 10000000; i++){
				BasicDBObject basicDb = new BasicDBObject();
				basicDb.put("customer_credential", i);
				if(i%2 == 0)
					basicDb.put("time_segment", 60);
				else
					basicDb.put("time_segment", 90);
				basicDb.put("current_aisle", "a"+i);
				basicDb.put("next_aisle", "a"+(i+1));
				basicDb.put("frequency", i%2);
				mongoCollection.insert(basicDb);
				System.out.println("inserted document successfully : " + i);
			}
			//mongoCollection.createIndex(new BasicDBObject("customer_credential",1));
			List<Integer> vals = Arrays.asList(39,45,67,1000,10000,200000,1000000);
			
			BasicDBObject query = new BasicDBObject("customer_credential", new BasicDBObject("$in", vals));
			DBCursor test = mongoCollection.find(query);
			while(test.hasNext()){
				System.out.println(test.next());
			}*/
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(mongo != null){
				mongo.close();
				long diff = System.currentTimeMillis() - startTime;
				System.out.println("TIME TAKEN TO INSERT 10000000 rows :: " + diff);
			}
		}
		
	}
	

	/*@Override
	 public Map<String, List<PredictionCartItemVO>> getScannedItemsForListOfCustomers(List<String> customerIds) throws DataAccessException{
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        String sql = CCQueries.Prediction.getScannedItemsForListOfTrips();
	        Map<String , List<PredictionCartItemVO>> tripToCartItems = new HashMap<String, List<PredictionCartItemVO>>();
	        DBCollection collection = mongoDb.getCollection(COLLECTION_NAME);
	        BasicDBObject dbOBject = new BasicDBObject();
	        Map<String, AisleVO> upcAisleMappingCache = predDataCache.getUpcToAisleMapping();
	        try {
	            conn = getConnection();
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            int i = 0;
	            while (rs.next()) {
	            	
	            	dbOBject.put("dbUpc", rs.getString("db_upc"));
	            	dbOBject.put("upc", rs.getString("upc"));
	            	dbOBject.put("tripId", rs.getLong("trip_id"));
	            	dbOBject.put("ACTION_TIME", rs.getString("ACTION_TIME"));
	            	dbOBject.put("upcCheckDigit", rs.getString("upc_check_digit"));
	            	dbOBject.put("addedToCart", rs.getString("added_to_cart"));
	            	dbOBject.put("aisle", upcAisleMappingCache.get(rs.getString("db_upc")).getAisleId());
	            	PredictionCartItemVO vo = new PredictionCartItemVO();
					vo.setDbUpc(rs.getString("db_upc"));
					vo.setDbUpc(rs.getString("upc"));
					vo.setActionTime(new Date(rs.getTimestamp("ACTION_TIME").getTime()));
					//vo.setAisle(upcAisleMappingCache.get(vo.getDbUpc()).getAisleId());
					vo.setTripId(rs.getLong("trip_id"));
					logger.logDebug(this, rs.getString("db_upc") + " Number of items " + (++i));
					collection.insert(dbOBject);
	            }
	            return tripToCartItems;
	        } catch (SQLException e) {
	            throw new DataAccessException(e);
	        } finally {
	            cleanUp(conn, pstmt, rs);
	        }
	    }*/
	
	/*public static void main(String args[]) throws NamingException, SQLException{
		try {
			 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
		
		Connection connection = null;
		 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://10.12.123.55:5432/modivapp", "ccuser",
					"@mmedia");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		Connection conn = connection;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CCQueries.Prediction.getScannedItemsForListOfTrips();
		List<String> test = new ArrayList<String>();
		test.add("2212564762739");
		test.add("2212546848130");
		test.add("2212547067202");
		Array sqlArray = conn.createArrayOf("text", new String[]{"1","2"});
		String id = getCustomerAsSqlString(test);
		//String id = StringUtils.join(test, ",");
		//System.out.println("params :: " + id);
		try {
            pstmt = conn.prepareStatement(sql);
           // pstmt.setArray(1, sqlArray);
            //pstmt.setString(1, id);
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
            	System.out.println(rs.getString("trip_id"));
            }
		} catch (SQLException e) {
	            try {
	            	e.printStackTrace();
					throw new DataAccessException(e);
				} catch (DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}*/
}
