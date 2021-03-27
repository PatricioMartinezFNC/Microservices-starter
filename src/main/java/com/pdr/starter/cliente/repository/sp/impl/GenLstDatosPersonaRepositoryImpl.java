package com.pdr.starter.cliente.repository.sp.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.CommonRequestDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.repository.sp.GenLstDatosPersonaRepository;
import com.pdr.starter.cliente.utils.GenericUtils;

import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class GenLstDatosPersonaRepositoryImpl implements GenLstDatosPersonaRepository{
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Map<String, Object> getDatosCliente(GenPersonaIdRequest dto) {
		
		log.info("[getListaClientes]:: Inicio llamada al procedimiento de oracle");
		
		Map<String, Object> out;
		CommonRequestDTO commonRequest = new CommonRequestDTO();
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("genpar")
				.withCatalogName("").withFunctionName("gen_get_lst_datos_persona")
				.declareParameters(new SqlOutParameter("result", Types.REF_CURSOR),
						new SqlParameter("P_COUNT", Types.NUMERIC), 
						new SqlParameter("P_OFFSET", Types.NUMERIC),
						new SqlParameter("P_NUMREG", Types.NUMERIC), 
						new SqlOutParameter("P_TOT_REG", Types.NUMERIC),
						new SqlOutParameter("P_COD_ERR", Types.NUMERIC),
						new SqlOutParameter("P_DES_ERR", Types.VARCHAR), 
						new SqlParameter("P_ORD_BY", Types.VARCHAR),
						new SqlParameter("P_PERS_TIPO_ID", Types.VARCHAR),
						new SqlParameter("P_PERS_ID", Types.VARCHAR)
						)
				.returningResultSet("result", new RowMapper<ClienteDatosResponseDTO>() {
					@Override
					public ClienteDatosResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowDatosClientes(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource()
				.addValue("P_COUNT", commonRequest.getCount())
				.addValue("P_OFFSET", commonRequest.getOffSet())
				.addValue("P_NUMREG", commonRequest.getNumReg())
				.addValue("P_ORD_BY", commonRequest.getOrderBy())
				.addValue("P_PERS_ID", dto.getPersId())
				.addValue("P_PERS_TIPO_ID", dto.getPersTipoId());


		jdbcCall.compile();
		out = jdbcCall.execute(paramMap);

		log.info("[getListaClientes]:: Fin llamada al procedimiento de oracle");
		return out;
	}
	
	
	private ClienteDatosResponseDTO mapRowDatosClientes(ResultSet rs) throws SQLException {
		
		ClienteDatosResponseDTO dto = new ClienteDatosResponseDTO();
		dto.setPersTipo(GenericUtils.ifNullisBlank(rs.getObject("PERS_TIPO")));
		dto.setPersTipoId(GenericUtils.ifNullisBlank(rs.getObject("PERS_TIPO_ID")));
		dto.setPersTipoIdDesc(GenericUtils.ifNullisBlank(rs.getObject("PERS_TIPO_ID_DESC")));
		dto.setPersId(GenericUtils.ifNullisCero(rs.getObject("PERS_ID")));
		dto.setPersDigVer(GenericUtils.ifNullisBlank(rs.getObject("PERS_DIG_VER")));
		dto.setPersIdFmt(GenericUtils.ifNullisBlank(rs.getObject("PERS_ID_FMT")));
		dto.setPersApePat(GenericUtils.ifNullisBlank(rs.getObject("PERS_APE_PAT")));
		dto.setPersApeMat(GenericUtils.ifNullisBlank(rs.getObject("PERS_APE_MAT")));
		dto.setPersNombres(GenericUtils.ifNullisBlank(rs.getObject("PERS_NOMBRES")));
		dto.setPersRazonSocial(GenericUtils.ifNullisBlank(rs.getObject("PERS_RAZON_SOCIAL")));
		dto.setPersNomFantasia(GenericUtils.ifNullisBlank(rs.getObject("PERS_NOM_FANTASIA")));
		dto.setPersNomFMT(GenericUtils.ifNullisBlank(rs.getObject("PERS_NOM_FMT")));
		dto.setPersNivelEduc(GenericUtils.ifNullisBlank(rs.getObject("PERS_NIVEL_EDUC")));
		dto.setPersFecNac(GenericUtils.ifNullisDate(rs.getObject("PERS_FEC_NAC")));
		dto.setPersFecDefun(GenericUtils.ifNullisDate(rs.getObject("PERS_FEC_DEFUN")));
		dto.setPersEdadDefun(GenericUtils.ifNullisBlank(rs.getObject("PERS_EDAD_DEFUN")));
		dto.setEdadFmt(GenericUtils.ifNullisBlank(rs.getObject("EDAD_FMT")));
		dto.setPersEstCivil(GenericUtils.ifNullisBlank(rs.getObject("PERS_EST_CIVIl")));
		dto.setPersEstCivilFmt(GenericUtils.ifNullisBlank(rs.getObject("PERS_EST_CIVIl_FMT")));
		dto.setPersNaci(GenericUtils.ifNullisBlank(rs.getObject("PERS_NACI")));
		dto.setPersSexo(GenericUtils.ifNullisBlank(rs.getObject("PERS_SEXO")));
		dto.setPersMod(GenericUtils.ifNullisBlank(rs.getObject("PERS_MOD")));
		dto.setPersGiro(GenericUtils.ifNullisBlank(rs.getObject("PERS_GIRO")));
		dto.setPersModFall(GenericUtils.ifNullisBlank(rs.getObject("PERS_MOD_FALL")));
		dto.setSexoDesc(GenericUtils.ifNullisBlank(rs.getObject("SEXO_DESC")));
		dto.setPersFecNacFmt(GenericUtils.ifNullisBlank(rs.getObject("PERS_FEC_NAC_FMT")));
		dto.setPersFecDefunFmt(GenericUtils.ifNullisBlank(rs.getObject("PERS_FEC_DEFUN_FMT")));
		
		
		return dto;
	}


}
