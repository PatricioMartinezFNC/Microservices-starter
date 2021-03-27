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

import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.CommonRequestDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.repository.sp.AtcparGetListContRolRepository;
import com.pdr.starter.cliente.utils.GenericUtils;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AtcparGetListContRolRepositoryImpl implements AtcparGetListContRolRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Map<String, Object> getListContratos(GenPersonaIdRequest dto) {
		
		log.info("[getListContratos]:: Inicio llamada al procedimiento de oracle");
		
		Map<String, Object> out;
		CommonRequestDTO commonRequest = new CommonRequestDTO();
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("atcpar")
				.withCatalogName("").withFunctionName("atc_get_lst_cont_rol")
				.declareParameters(new SqlOutParameter("result", Types.REF_CURSOR),
						new SqlParameter("P_COUNT", Types.NUMERIC), 
						new SqlParameter("P_OFFSET", Types.NUMERIC),
						new SqlParameter("P_NUMREG", Types.NUMERIC), 
						new SqlOutParameter("P_TOT_REG", Types.NUMERIC),
						new SqlOutParameter("P_COD_ERR", Types.NUMERIC),
						new SqlOutParameter("P_DES_ERR", Types.VARCHAR), 
						new SqlParameter("P_ORD_BY", Types.VARCHAR),
						new SqlParameter("P_PERS_TIPO_ID", Types.VARCHAR),
						new SqlParameter("P_PERS_ID", Types.VARCHAR),
						new SqlParameter("P_ESTA_DOM", Types.VARCHAR),
						new SqlParameter("P_SERIE_COD", Types.VARCHAR),
						new SqlParameter("P_DOCTO_FOLIO", Types.NUMERIC),
						new SqlParameter("P_TIPO_QUERY", Types.VARCHAR),
						new SqlParameter("P_NUM_OPE", Types.NUMERIC)
						)
				.returningResultSet("result", new RowMapper<ClienteContratosResponseDTO>() {
					@Override
					public ClienteContratosResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowContratosClientes(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource()
				.addValue("P_COUNT", commonRequest.getCount())
				.addValue("P_OFFSET", commonRequest.getOffSet())
				.addValue("P_NUMREG", commonRequest.getNumReg())
				.addValue("P_ORD_BY", commonRequest.getOrderBy())
				.addValue("P_PERS_ID", dto.getPersId())
				.addValue("P_PERS_TIPO_ID", dto.getPersTipoId())
				.addValue("P_ESTA_DOM", null)
				.addValue("P_SERIE_COD", null)
				.addValue("P_DOCTO_FOLIO", null)
				.addValue("P_TIPO_QUERY", null)
				.addValue("P_NUM_OPE", null);

		jdbcCall.compile();
		out = jdbcCall.execute(paramMap);

		log.info("[getListContratos]:: Fin llamada al procedimiento de oracle");
		return out;
	}
	
	
	private ClienteContratosResponseDTO mapRowContratosClientes(ResultSet rs) throws SQLException {
		ClienteContratosResponseDTO dto = new ClienteContratosResponseDTO();
		dto.setEmprCod(GenericUtils.ifNullisBlank(rs.getObject("EMPR_COD")));
		dto.setUnegCod(GenericUtils.ifNullisBlank(rs.getObject("UNEG_COD")));
		dto.setUnegEmprDesc(GenericUtils.ifNullisBlank(rs.getObject("UNEG_EMPR_DESC")));
		dto.setContVtopNumFmt(GenericUtils.ifNullisBlank(rs.getObject("CONT_VTOP_NUM_FMT")));
		dto.setTipoProducto(GenericUtils.ifNullisBlank(rs.getObject("TIPO_PRODUCTO")));
		dto.setContVtopFech(GenericUtils.ifNullisDate(rs.getObject("CONT_VTOP_FECH")));
		dto.setContVtopFechFmt(GenericUtils.ifNullisBlank(rs.getObject("CONT_VTOP_FECH_FMT")));
		dto.setContVtopEsta(GenericUtils.ifNullisBlank(rs.getObject("CONT_VTOP_ESTA")));
		dto.setContVtopEstaDesc(GenericUtils.ifNullisBlank(rs.getObject("CONT_VTOP_ESTA_DESC")));
		dto.setConVtopNece(GenericUtils.ifNullisBlank(rs.getObject("CONT_VTOP_NECE")));
		dto.setConVtopNeceDesc(GenericUtils.ifNullisBlank(rs.getObject("CONT_VTOP_NECE_DESC")));
		dto.setRol(GenericUtils.ifNullisBlank(rs.getObject("ROL")));
		dto.setIndEstaDeudaDesc(GenericUtils.ifNullisBlank(rs.getObject("IND_ESTA_DEUDA_DESC")));
		dto.setPersIdCompFmt(GenericUtils.ifNullisBlank(rs.getObject("PERS_ID_COMP_FMT")));
		dto.setPersNomCompFmt(GenericUtils.ifNullisBlank(rs.getObject("PERS_NOM_COMP_FMT")));
		dto.setUbicFmt(GenericUtils.ifNullisBlank(rs.getObject("UBIC_FMT")));
		dto.setPersTipoIdComp(GenericUtils.ifNullisBlank(rs.getObject("PERS_TIPO_ID_COMP")));
		dto.setPersIdComp(GenericUtils.ifNullisCero(rs.getObject("PERS_ID_COMP")));
		dto.setVtopCod(GenericUtils.ifNullisCero(rs.getObject("VTOP_COD")));
		dto.setVtopCodCont(GenericUtils.ifNullisCero(rs.getObject("VTOP_COD_CONT")));
		dto.setPesoRol(GenericUtils.ifNullisCero(rs.getObject("PESO_ROL")));
		dto.setTipoDocto(GenericUtils.ifNullisBlank(rs.getObject("TIPO_DOCTO")));
		dto.setNumDocto(GenericUtils.ifNullisCero(rs.getObject("NUM_DOCTO")));
		dto.setLnngCod(GenericUtils.ifNullisBlank(rs.getObject("LNNG_COD")));
		dto.setVtopIndNif(GenericUtils.ifNullisBlank(rs.getObject("VTOP_IND_NIF")));
		dto.setNumOpe(GenericUtils.ifNullisCero(rs.getObject("NUM_OPE")));
		
		return dto;
	}

}
