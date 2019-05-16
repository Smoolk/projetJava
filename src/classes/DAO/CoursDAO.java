package classes.DAO;

/**
 * classe de mappage poo-relationnel cours
 *
 * @author Michel Poriaux
 * @version 1.0
 * @see Cours
 */
import java.sql.*;
import java.util.*;
import classes.metiers.Cours;

public class CoursDAO extends DAO<Cours> {

    /**
     * création d'un cours sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj cours à créer
     * @return cours créé
     */
    @Override
    public Cours create(Cours obj) throws SQLException {
        
        String req1 = "insert into PROJ_COURS(matiere, heures) values(?,?)";
        String req2 = "select idcours from PROJ_COURS where matiere=? and heures=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatière());
            pstm1.setInt(2, obj.getHeures());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation cours, aucune ligne créée");
            }
            pstm2.setString(1, obj.getMatière());
            pstm2.setInt(2, obj.getHeures());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idcours = rs.getInt(1);
                    obj.setIdcours(idcours);
                    return read(idcours);
                } else {
                    throw new SQLException("erreur de création cours, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un cours sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idcours identifiant du cours
     * @return cours trouvé
     */
    @Override
    public Cours read(int idcours) throws SQLException {

        String req = "select * from PROJ_COURS where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idcours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");
                    return new Cours(idcours, matiere, heures);
                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du cours sur base de son identifiant
     *
     * @return Cours
     * @param obj cours à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Cours update(Cours obj) throws SQLException {
        String req = "update PROJ_COURS set matiere=?, heures=? where idcours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(3, obj.getIdcours());
            pstm.setString(1, obj.getMatière());
            pstm.setInt(2, obj.getHeures());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne cours mise à jour");
            }
            return read(obj.getIdcours());
        }
    }

    /**
     * effacement du cours sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj cours à effacer
     */
    @Override
    public void delete(Cours obj) throws SQLException {

        String req = "delete from PROJ_COURS where idcours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdcours());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne cours effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les cours portant un
     * certain nom
     * @param nomrech nom recherché
     * @return liste de cours
     * @throws SQLException nom inconnu
     */
    public List<Cours> rechNom(String nomrech) throws SQLException {
        List<Cours> plusieurs = new ArrayList<>();
        String req = "select * from PROJ_COURS where matiere like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+nomrech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idcours = rs.getInt("IDCOURS");
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");
                    plusieurs.add(new Cours(idcours, matiere, heures));
                }

                if (!trouve) {
                    throw new SQLException(" aucun cours !");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
    
    /**
     * méthode permettant de récupérer la date de la dernière commande d'un cours
     * @param obj cours recherché
     * @return  date de la dernière commande
     * @throws SQLException cours sans commande
     */
    /**public CoursDate dern_com(Cours obj) throws SQLException{
         String req = "select derniere_com from CLIDATE where idcours = ?";
         try(PreparedStatement pstm = dbConnect.prepareStatement(req)){
             pstm.setInt(1,obj.getIdcours());
             try(ResultSet rs = pstm.executeQuery()){
                 if(rs.next()){
                     CoursDate dt = rs.getDate(1).toCoursDate();
                     return dt;
                 }
                 else throw new SQLException("aucune commande enregistrée pour ce cours");
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
	public Cours read(int id)throws SQLException{
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
	public Cours create(Cours obj) throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj objet à mettre à jour
         * @throws SQLException exception  mise à jour
         * @return T objet mis à jour
	 */
        /**@Override
	public Cours update(Cours obj)throws SQLException{
            return null;
        }**/
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj objet à effacer
         * @throws SQLException exception d'effacement
	 */
        /**@Override
	public void delete(Cours obj) throws SQLException{
        }**/

}
