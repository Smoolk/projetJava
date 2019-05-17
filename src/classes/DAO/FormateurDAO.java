package classes.DAO;

/**
 * classe de mappage poo-relationnel formateur
 *
 * @author Michel Poriaux
 * @version 1.0
 * @see Formateur
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import classes.metiers.Formateur;

public class FormateurDAO extends DAO<Formateur> {

    /**
     * création d'un formateur sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj formateur à créer
     * @return formateur créé
     */
    @Override
    public Formateur create(Formateur obj) throws SQLException {
        
        String req1 = "insert into PROJ_FORMATEUR(matricule, nom, prenom, numero, rue, localite, cp, tel) values(?,?,?,?,?,?,?,?)";
        String req2 = "select idform from PROJ_FORMATEUR where matricule=? and nom=? and prenom=? and numero=? and rue=? and localite=? and cp=? and tel=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setString(4, obj.getNumero());
            pstm1.setString(5, obj.getRue());
            pstm1.setString(6, obj.getLocalite());
            pstm1.setInt(7, obj.getCp());
            pstm1.setString(8, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation formateur, aucune ligne créée");
            }
            pstm2.setString(1, obj.getMatricule());
            pstm2.setString(2, obj.getNom());
            pstm2.setString(3, obj.getPrenom());
            pstm2.setString(4, obj.getNumero());
            pstm2.setString(5, obj.getRue());
            pstm2.setString(6, obj.getLocalite());
            pstm2.setInt(7, obj.getCp());
            pstm2.setString(8, obj.getTel());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idform = rs.getInt(1);
                    obj.setIdform(idform);
                    return read(idform);
                } else {
                    throw new SQLException("erreur de création formateur, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un formateur sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idform identifiant du formateur
     * @return formateur trouvé
     */
    @Override
    public Formateur read(int idform) throws SQLException {

        String req = "select * from PROJ_FORMATEUR where idform = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String numero = rs.getString("NUMERO");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    int cp = rs.getInt("CP");
                    String tel = rs.getString("TEL");
                    return new Formateur(idform, matricule, nom, prenom, numero, rue, localite, cp, tel);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du formateur sur base de son identifiant
     *
     * @return Formateur
     * @param obj formateur à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Formateur update(Formateur obj) throws SQLException {
        String req = "update PROJ_FORMATEUR set matricule=?, nom=?, prenom=?, numero=?, rue=?, localite=?, cp=?, tel=? where idform=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getMatricule());
            pstm.setString(2, obj.getNom());
            pstm.setString(3, obj.getPrenom());
            pstm.setString(4, obj.getNumero());
            pstm.setString(5, obj.getRue());
            pstm.setString(6, obj.getLocalite());
            pstm.setInt(7, obj.getCp());
            pstm.setString(8, obj.getTel());
            pstm.setInt(9, obj.getIdform());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne formateur mise à jour");
            }
            return read(obj.getIdform());
        }
    }

    /**
     * effacement du formateur sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj formateur à effacer
     */
    @Override
    public void delete(Formateur obj) throws SQLException {

        String req = "delete from PROJ_FORMATEUR where idform= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdform());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne formateur effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les formateurs portant un
     * certain nom
     * @param nomrech nom recherché
     * @return liste de formateurs
     * @throws SQLException nom inconnu
     */
    public List<Formateur> rechNom(String nomrech) throws SQLException {
        List<Formateur> plusieurs = new ArrayList<>();
        String req = "select * from PROJ_FORMATEUR where nom like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+nomrech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idform = rs.getInt("IDFORM");
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String numero = rs.getString("NUMERO");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    int cp = rs.getInt("CP");
                    String tel = rs.getString("TEL");
                    plusieurs.add(new Formateur(idform, matricule, nom, prenom, numero, rue, localite, cp, tel));
                }

                if (!trouve) {
                    throw new SQLException(" aucun formateur !");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
    
    /**
     * méthode permettant de récupérer la date de la dernière commande d'un formateur
     * @param obj formateur recherché
     * @return  date de la dernière commande
     * @throws SQLException formateur sans commande
     */
    /**public FormateurDate dern_com(Formateur obj) throws SQLException{
         String req = "select derniere_com from CLIDATE where idform = ?";
         try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
             pstm.setInt(1,obj.getIdform());
             try(ResultSet rs = pstm.executeQuery()){
                 if(rs.next()){
                     FormateurDate dt = rs.getDate(1).toFormateurDate();
                     return dt;
                 }
                 else throw new SQLException("aucune commande enregistrée pour ce formateur");
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
	public Formateur read(int id)throws SQLException{
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
	public Formateur create(Formateur obj) throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj objet à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T objet mis à jour
	 */
        /**@Override
	public Formateur update(Formateur obj)throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj objet à effacer
         * @throws SQLException exception d'effacement
	 */
        /**@Override
	public void delete(Formateur obj) throws SQLException{
        }**/

}
