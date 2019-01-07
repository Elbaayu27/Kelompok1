/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klp1.entity;

/**
 *
 * @author Elba
 */
public class Surat {
    
    private String nama_barang;
    private String nama_perusahaan;
    private String admin_perusahaan;
    private String validasi;
    private String alamat;

    public String getNamaBarang() {
        return nama_barang;
    }

    public void setNamaBarang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    
    public String getNamaPerusahaan() {
        return nama_perusahaan;
    }

    public void setNamaPerusahaan(String nama_perusahaan) {
        this.nama_perusahaan = nama_perusahaan;
    }
    public String getAdminPerusahaan() {
        return admin_perusahaan;
    }

    public void setAdminPerusahaan(String admin_perusahaan) {
        this.admin_perusahaan = admin_perusahaan;
    }
    
    public String getValidasi() {
        return validasi;
    }

    public void setValidasi(String validasi) {
        this.validasi = validasi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
