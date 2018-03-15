package kr.or.dgit.it_3st_3team.ui.component;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.ui.SoftwareGroupUI;

@SuppressWarnings("serial")
public class LblTfBtnSGRegisterComp extends AbstractLblTfBtnComp {

	private SoftwareGroupUI ui;

	/**
	 * Create the panel.
	 */
	public LblTfBtnSGRegisterComp(String title, String btnName) {
		super(title, btnName);
	}

	public String rgTf() {
		String a = ui.getpSgTable().table.getValueAt(ui.getpSgTable().table.getSelectedRow(), 0).toString();

		return a;
	}

	@Override
	protected void actionPerformedBtn(ActionEvent e) {

		String tfSgName = getTfText();

		if (e.getActionCommand() == "등록") {
			if (tfSgName.equals("")) {
				JOptionPane.showMessageDialog(null, "분류명을 입력해주세요.");
				return;
			}

			SoftwareGroupService.getInstance().insertSoftwareGroup(new SoftwareGroup(tfSgName));

		} else {
			int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "분류명 수정", JOptionPane.OK_CANCEL_OPTION);
			if (result == 0) {
			
			Map<String, String> map = new HashMap<>();
			map.put("changeSgName", tfSgName);
			map.put("oriSgName", rgTf());
				
			SoftwareGroupService.getInstance().updateSoftwareGroup(map);
			setBtnTitle("등록");
			}
		}

		List<SoftwareGroup> lists = SoftwareGroupService.getInstance().selectSoftwareGroupByAll();
		ui.getpSgTable().loadTableDatas(lists);
		setTfText("");

		SoftwareGroup[] sgDatas = lists.toArray(new SoftwareGroup[lists.size()]);
		ui.getParentUi().getpSWsort().loadData(sgDatas);

	}

	public void setUI(SoftwareGroupUI ui) {
		this.ui = ui;
	}

}
