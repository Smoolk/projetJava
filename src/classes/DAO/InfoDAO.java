package classes.DAO;

/**
 * classe de mappage poo-relationnel info
 *
 * @author Michel Poriaux
 * @version 1.0
 * @see Info
 */
import java.sql.*;
import java.util.*;
import classes.metiers.Infos;

public class InfoDAO extends DAO<Infos> {

    /**
     * création d'un info sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj info à créer
     * @return info créé
     */
    @Override
    public Infos create(Infos obj) throws SQLException {
        
        String req1 = "insert into PROJ_INFOS(NH, idform, idsesscours) values(?,?,?)";
        String req2 = "select idinfos from PROJ_INFOS where NH=? and idform=? and idsesscours=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getNh());
            pstm1.setInt(2, obj.getIdform());
            pstm1.setInt(3, obj.getIdsesscours());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation info, aucune ligne créée");
            }
            pstm2.setInt(1, obj.getNh());
            pstm2.setInt(2, obj.getIdform());
            pstm2.setInt(3, obj.getIdsesscours());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idinfos = rs.getInt(1);
                    obj.setIdinfos(idinfos);
                    return read(idinfos);
                } else {
                    throw new SQLException("erreur de création info, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un info sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idinfo identifiant du info
     * @return info trouvé
     */
    @Override
    public Infos read(int idinfos) throws SQLException {

        String req = "select * from PROJ_INFOS where idinfos = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idinfos);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int nh = rs.getInt("NH");
                    int idform = rs.getInt("IDFORM");
                    int idsess = rs.getInt("IDSESSCOURS");
                    int idinf = rs.getInt("IDINFOS");
                    return new Infos(nh, idform, idsess, idinf);
                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }
    
    
    
    public Infos read1(int idinfos) throws SQLException {

        String req = "select * from PROJ_INFOS where idsesscours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idinfos);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int nh = rs.getInt("NH");
                    int idform = rs.getInt("IDFORM");
                    int idsess = rs.getInt("IDSESSCOURS");
                    int idinf = rs.getInt("IDINFOS");
                    return new Infos(nh, idform, idsess, idinf);
                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du info sur base de son identifiant
     *
     * @return Info
     * @param obj info à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Infos update(Infos obj) throws SQLException {
        /*String req = "update PROJ_COURS set matiere=?, heures=? where idinfo=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(3, obj.getIdinfo());
            pstm.setString(1, obj.getMatière());
            pstm.setInt(2, obj.getHeures());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne info mise à jour");
            }
            return read(obj.getIdinfo());
        }*/
        return null;
    }

    /**
     * effacement du info sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj info à effacer
     */
    @Override
    public void delete(Infos obj) throws SQLException {
        System.out.println(obj.getIdsesscours());
        String req = "delete from PROJ_INFOS where idsesscours = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdsesscours());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne info effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les info portant un
     * certain nom
     * @param nomrech nom recherché
     * @return liste de info
     * @throws SQLException nom inconnu
     */
    public List<Infos> rechNom(String nomrech) throws SQLException {
        /*List<Info> plusieurs = new ArrayList<>();
        String req = "select * from PROJ_COURS where matiere like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+nomrech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idinfo = rs.getInt("IDCOURS");
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");
                    plusieurs.add(new Info(idinfo, matiere, heures));
                }

                if (!trouve) {
                    throw new SQLException(" aucun info !");
                } else {
                    return plusieurs;
                }
            }
        }*/
        return null;
        
    }
    
    
    /**
     * méthode permettant de récupérer la date de la dernière commande d'un info
     * @param obj info recherché
     * @return  date de la dernière commande
     * @throws SQLException info sans commande
     */
    /**public InfoDate dern_com(Info obj) throws SQLException{
         String req = "select derniere_com from CLIDATE where idinfo = ?";
         try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
             pstm.setInt(1,obj.getIdinfo());
             try(ResultSet rs = pstm.executeQuery()){
                 if(rs.next()){
                     InfoDate dt = rs.getDate(1).toInfoDate();
                     return dt;
                 }
                 else throw new SQLException("aucune commande enregistrée pour ce info");
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
	public Info read(int id)throws SQLException{
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
	public Info create(Info obj) throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj objet à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T objet mis à jour
	 */
        /**@Override
	public Info update(Info obj)throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj objet à effacer
         * @throws SQLException exception d'effacement
	 */
        /**@Override
	public void delete(Info obj) throws SQLException{
        }**/

}
