package dao;

import bean.AlunoBean;
import conexao.ConnectionA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michelle de Jesus Rogério
 */
public class AlunoDao {

    public int inserir(AlunoBean aluno) {
        Connection conexao = ConnectionA.obterConexao();
        if (conexao != null) {
            String sql = "INSERT INTO alunos"
                    + "\n(id, nome, cod_matricula, nota1, nota2, nota3, frequencia)"
                    + "\nVALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = conexao
                        .prepareStatement(sql,
                                PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, aluno.getId());
                preparedStatement.setString(2, aluno.getCodMatricula());
                preparedStatement.setString(3, aluno.getNome());
                preparedStatement.setDouble(4, aluno.getNota1());
                preparedStatement.setDouble(5, aluno.getNota2());
                preparedStatement.setDouble(6, aluno.getNota3());
                preparedStatement.setByte(7, aluno.getFrequencia());
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionA.fecharConexao();
            }
        }
        return 0;
    }

    public boolean alterar(AlunoBean aluno) {
        return false;
    }

    public boolean apagar(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?;";
        Connection conexao = ConnectionA.obterConexao();
        if (conexao != null) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionA.fecharConexao();
            }
        }
        return false;
    }

    public AlunoBean obterClientePeloId(int id) {
        String sql = "SELECT id, nome, cod_matricula, nota1, nota2, nota3, frequencia "
                + "FROM alunos WHERE id = ?;";
        Connection conexao = ConnectionA.obterConexao();
        if (conexao != null) {
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                ResultSet resultSet = ps.getResultSet();
                if (resultSet.next()) {
                    AlunoBean aluno = new AlunoBean();
                    aluno.setId(resultSet.getInt("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setCodMatricula(resultSet.getString("cod_matricula"));
                    aluno.setNota1(resultSet.getDouble("nota1"));
                    aluno.setNota2(resultSet.getDouble("nota2"));
                    aluno.setNota3(resultSet.getDouble("nota3"));
                    aluno.setFrequencia(resultSet.getByte("frequencia"));
                    return aluno;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionA.fecharConexao();
            }
        }
        return null;
    }

    public List<AlunoBean> obterClientes() {
        List<AlunoBean> alunos = new ArrayList<>();
        Connection conexao = ConnectionA.obterConexao();
        if (conexao != null) {
            String sql = "SELECT id, nome, cod_matricula, nota1, nota2, nota3, frequencia"
                    + " FROM alunos";
            try {
                Statement statement = conexao.createStatement();
                statement.execute(sql);
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    AlunoBean aluno = new AlunoBean();
                    aluno.setId(resultSet.getInt("id"));
                    aluno.setNome(resultSet.getString("nome"));
                    aluno.setCodMatricula(resultSet.getString("cod_matricula"));
                    aluno.setNota1(resultSet.getDouble("nota1"));
                    aluno.setNota2(resultSet.getDouble("nota2"));
                    aluno.setNota3(resultSet.getDouble("nota3"));
                    aluno.setFrequencia(resultSet.getByte("frequencia"));
                    alunos.add(aluno);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionA.fecharConexao();
            }
        }
        return alunos;
    }
}
