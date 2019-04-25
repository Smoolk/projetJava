package classes.DAO;

/**
 * classe de mappage poo-relationnel local
 *
 * @author Michel Poriaux
 * @version 1.0
 * @see Local
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import classes.metiers.Local;

public class LocalDAO extends DAO<Local> {

    /**
     * création d'un local sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj local à créer
     * @return local créé
     */
    @Override
    public Local create(Local obj) throws SQLException {
        
        String req1 = "insert into PROJ_LOCAL(sigle, places, description) values(?,?,?)";
        String req2 = "select idlocal from PROJ_LOCAL where sigle=? and places=? and description=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getSigle());
            pstm1.setInt(2, obj.getPlaces());
            pstm1.setString(3, obj.getDescription());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation local, aucune ligne créée");
            }
            pstm2.setString(1, obj.getSigle());
            pstm2.setInt(2, obj.getPlaces());
            pstm2.setString(3, obj.getDescription());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idlocal = rs.getInt(1);
                    obj.setIdlocal(idlocal);
                    return read(idlocal);
                } else {
                    throw new SQLException("erreur de création local, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un local sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idlocal identifiant du local
     * @return local trouvé
     */
    @Override
    public Local read(int idlocal) throws SQLException {

        String req = "select * from PROJ_LOCAL where idlocal = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idlocal);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    return new Local(idlocal, sigle, places, description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du local sur base de son identifiant
     *
     * @return Local
     * @param obj local à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Local update(Local obj) throws SQLException {
        String req = "update PROJ_LOCAL set sigle=?, places=?, description=? where idlocal=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(4, obj.getIdlocal());
            pstm.setString(1, obj.getSigle());
            pstm.setInt(2, obj.getPlaces());
            pstm.setString(3, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne local mise à jour");
            }
            return read(obj.getIdlocal());
        }
    }

    /**
     * effacement du local sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj local à effacer
     */
    @Override
    public void delete(Local obj) throws SQLException {

        String req = "delete from PROJ_LOCAL where idlocal= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdlocal());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne local effacée");
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
    public List<Local> rechNom(String nomrech) throws SQLException {
        List<Local> plusieurs = new ArrayList<>();
        String req = "select * from PROJ_LOCAL where description like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+nomrech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idlocal = rs.getInt("IDLOCAL");
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    plusieurs.add(new Local(idlocal, sigle, places, description));
                }

                if (!trouve) {
                    throw new SQLException(" aucun local !");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
    
    /**
     * méthode permettant de récupérer la date de la dernière commande d'un local
     * @param obj local recherché
     * @return  date de la dernière commande
     * @throws SQLException local sans commande
     */
    /**public LocalDate dern_com(Local obj) throws SQLException{
         String req = "select derniere_com from CLIDATE where idlocal = ?";
         try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
             pstm.setInt(1,obj.getIdlocal());
             try(ResultSet rs = pstm.executeQuery()){
                 if(rs.next()){
                     LocalDate dt = rs.getDate(1).toLocalDate();
                     return dt;
                 }
                 else throw new SQLException("aucune commande enregistrée pour ce local");
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
	public Local read(int id)throws SQLException{
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
	public Local create(Local obj) throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj objet à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T objet mis à jour
	 */
        /**@Override
	public Local update(Local obj)throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj objet à effacer
         * @throws SQLException exception d'effacement
	 */
        /**@Override
	public void delete(Local obj) throws SQLException{
        }**/

}
