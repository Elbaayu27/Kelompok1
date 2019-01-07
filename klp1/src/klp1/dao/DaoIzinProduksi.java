/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import klp1.config.Koneksi;
import klp1.entity.IzinProduksi;
import klp1.service.ServiceIzinProduksi;

/**
 *
 * @author Elba
 */
public class DaoIzinProduksi implements ServiceIzinProduksi {
    
    private Connection connection;
    
    public DaoIzinProduksi() throws SQLException{
        connection = Koneksi.getConnection();
    }
    
//    @Override
    public void createIzinProduksi(IzinProduksi s) throws SQLException{
        PreparedStatement st = null;
        String sql = "INSERT INTO tablesurat VALUE(?,?,?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, s.getNamaBarang());
            st.setString(2, s.getNamaPerusahaan());
            st.setString(3, s.getAdminPerusahaan());
            st.setString(4, s.getValidasi());
            st.setString(5, s.getAlamat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null){
                st.close();
            }
        }
    }
    
//    @Override
    public void updateIzinProduksi(IzinProduksi s) throws SQLException{
        PreparedStatement st = null;
        String sql = "UPDATE tablesurat SET nama_barang=?, nama_perusahaan=?, admin_perusahaan=?, validasi=?, alamat=? where id=?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, s.getNamaBarang());
            st.setString(2, s.getNamaPerusahaan());
            st.setString(3, s.getAdminPerusahaan());
            st.setString(4, s.getValidasi());
            st.setString(5, s.getAlamat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
        if (st != null){
            st.close();
        }
    }
   }
    
//    @Override
    public void deleteIzinProduksi(IzinProduksi s) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM tablesurat WHERE id=?";
        
        try {
            st = connection.prepareCall(sql);
            st.setString(1, s.getKodenasabah());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
//    @Override
    public IzinProduksi getIzinProduksiById(String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        IzinProduksi s = null;
        String sql = "SELECT * FROM tablesurat WHERE id=?";
        
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                s = new IzinProduksi();
                s.setId(rs.getString("id"));
                s.setNamaBarang(rs.getString("nama_barang"));
                s.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                s.setAdminPerusahaan(rs.getString("admin_perusahaan"));
                s.setValidasi(rs.getString("validasi"));
                s.setAlamat(rs.getString("alamat"));
            }
            return s;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null){
                st.close();
            }
            if (rs != null){
                rs.close();
            }
        }
    }
    
//    @Override
    public ArrayList<IzinProduksi> getIzinProduksi() throws SQLException {
        PreparedStatement st = null;
        ArrayList<IzinProduksi> listIzinProduksi = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tablesurat";
        
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                IzinProduksi s = new IzinProduksi();
                s.setId(rs.getString("id"));
                s.setNamaBarang(rs.getString("nama_barang"));
                s.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                s.setAdminPerusahaan(rs.getString("admin_perusahaan"));
                s.setValidasi(rs.getString("validasi"));
                s.setAlamat(rs.getString("alamat"));
                
                listIzinProduksi.add(s);
            }
            return listIzinProduksi;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if (rs != null){
                rs.close();
            }
        }
    }
    
}
