package classes.DAO;

/**
 * classe de mappage poo-relationnel session
 *
 * @author Michel Poriaux
 * @version 1.0
 * @see Session
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import classes.metiers.SessionCours;

public class SessionDAO extends DAO<Session> {

    /**
     * création d'un session sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj session à créer
     * @return session créé
     */
    @Override
    public Session create(Session obj) throws SQLException {
        
        String req1 = "insert into PROJ_LOCAL(sigle, places, description) values(?,?,?)";
        String req2 = "select idsession from PROJ_LOCAL where sigle=? and places=? and description=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getSigle());
            pstm1.setInt(2, obj.getPlaces());
            pstm1.setString(3, obj.getDescription());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation session, aucune ligne créée");
            }
            pstm2.setString(1, obj.getSigle());
            pstm2.setInt(2, obj.getPlaces());
            pstm2.setString(3, obj.getDescription());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idsession = rs.getInt(1);
                    obj.setIdsession(idsession);
                    return read(idsession);
                } else {
                    throw new SQLException("erreur de création session, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un session sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idsession identifiant du session
     * @return session trouvé
     */
    @Override
    public Session read(int idsession) throws SQLException {

        String req = "select * from PROJ_LOCAL where idsession = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idsession);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    return new Session(idsession, sigle, places, description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du session sur base de son identifiant
     *
     * @return Session
     * @param obj session à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Session update(Session obj) throws SQLException {
        String req = "update PROJ_LOCAL set sigle=?, places=?, description=? where idsession=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(4, obj.getIdsession());
            pstm.setString(1, obj.getSigle());
            pstm.setInt(2, obj.getPlaces());
            pstm.setString(3, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne session mise à jour");
            }
            return read(obj.getIdsession());
        }
    }

    /**
     * effacement du session sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj session à effacer
     */
    @Override
    public void delete(Session obj) throws SQLException {

        String req = "delete from PROJ_LOCAL where idsession= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdsession());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne session effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les locaux portant un
     * certain nom
     * @param nomrech nom recherché
     * @return liste de locaux
     * @throws SQLException nom inconnu
     */
    public List<Session> rechNom(String nomrech) throws SQLException {
        List<Session> plusieurs = new ArrayList<>();
        String req = "select * from PROJ_LOCAL where description like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+nomrech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idsession = rs.getInt("IDLOCAL");
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    plusieurs.add(new Session(idsession, sigle, places, description));
                }

                if (!trouve) {
                    throw new SQLException(" aucun session !");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
    
    /**
     * méthode permettant de récupérer la date de la dernière commande d'un session
     * @param obj session recherché
     * @return  date de la dernière commande
     * @throws SQLException session sans commande
     */
    /**public SessionDate dern_com(Session obj) throws SQLException{
         String req = "select derniere_com from CLIDATE where idsession = ?";
         try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
             pstm.setInt(1,obj.getIdsession());
             try(ResultSet rs = pstm.executeQuery()){
                 if(rs.next()){
                     SessionDate dt = rs.getDate(1).toSessionDate();
                     return dt;
                 }
                 else throw new SQLException("aucune commande enregistrée pour ce session");
             }
         }
    }
    **/
    
    /**
	 * Permet de récupérer un objet via son ID
	 * @param id identifiant de l'objet recherché
	 * @return T objet trouvé
         * @throws SQLException objet non trouvé
	 */
        /**@Override
	public Session read(int id)throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj objet à créer
         * @return T objet créé
         * @throws SQLException exception de création
	 */
        /**@Override
	public Session create(Session obj) throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj objet à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T objet mis à jour
	 */
        /**@Override
	public Session update(Session obj)throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj objet à effacer
         * @throws SQLException exception d'effacement
	 */
        /**@Override
	public void delete(Session obj) throws SQLException{
        }**/

}
